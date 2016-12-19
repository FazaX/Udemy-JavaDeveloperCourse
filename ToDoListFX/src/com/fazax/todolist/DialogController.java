package com.fazax.todolist;

import com.fazax.todolist.datamodel.ToDoData;
import com.fazax.todolist.datamodel.ToDoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

/**
 * Created by fazax on 07.10.2016.
 */
public class DialogController {

    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadlinePicker;

    public ToDoItem processResults() {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineDate = deadlinePicker.getValue();

            ToDoItem newItem = new ToDoItem(shortDescription,details,deadlineDate);
            ToDoData.getInstance().addTodoItem(newItem);
            return newItem;

    }
}
