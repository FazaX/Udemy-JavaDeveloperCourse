package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import sample.datamodel.Contact;
import sample.datamodel.ContactData;

import java.io.IOException;
import java.util.Optional;

public class MainController {
    @FXML
    private TableView<Contact> contactsTable;
    @FXML
    private TableColumn<Contact,String> firstNameColumn;
    @FXML
    private TableColumn<Contact,String> lastNameColumn;
    @FXML
    private TableColumn<Contact,String> phoneNumberColumn;
    @FXML
    private TableColumn<Contact,String> notesColumn;
    @FXML
    private BorderPane mainBorderPane;

    private ContactData contactData;


    public void initialize() {

        contactData = new ContactData();
        contactData.loadContacts();

        firstNameColumn.setCellValueFactory( cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory( cellData -> cellData.getValue().lastNameProperty());
        phoneNumberColumn.setCellValueFactory( cellData -> cellData.getValue().phoneNumberProperty());
        notesColumn.setCellValueFactory( cellData -> cellData.getValue().notesProperty());

        contactsTable.setItems(contactData.getContacts());
    }

    public void showAddContactDialog() {

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("New contact");
        dialog.setHeaderText("Add new Contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../view/contact-dialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch(IOException e){
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            ContactController controller = fxmlLoader.getController();
            Contact newContact = controller.addNewContact();
            contactData.addContact(newContact);
            contactData.saveContacts();
        }
    }

    public void showEditContactDialog() {
        Contact selectedContact = contactsTable.getSelectionModel().getSelectedItem();
        if (selectedContact == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No contact selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select contact first from table.");
            alert.showAndWait();
        } else {
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.initOwner(mainBorderPane.getScene().getWindow());
            dialog.setTitle("Edit contact");
            dialog.setHeaderText("Edit contact");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../view/contact-dialog.fxml"));
            try {
                dialog.getDialogPane().setContent(fxmlLoader.load());

            } catch(IOException e){
                System.out.println("Couldn't load the dialog");
                e.printStackTrace();
                return;
            }
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

            ContactController controller = fxmlLoader.getController();
            controller.editContact(selectedContact);

            Optional<ButtonType> result = dialog.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK) {
                controller.updateContact(selectedContact);
                contactData.saveContacts();
            }
        }

    }

    public void showDeleteConfirmation() {
        Contact selectedContact = contactsTable.getSelectionModel().getSelectedItem();
        if (selectedContact == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No contact selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select contact first from table.");
            alert.showAndWait();
        } else {

            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Deleting contact");
            confirmationAlert.setContentText("Are you sure you want to delete selected contact: " +
               selectedContact.getFirstName()+ " " + selectedContact.getLastName() );

            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK) {
                contactData.deleteContact(selectedContact);
                contactData.saveContacts();
            }

        }
    }
}
