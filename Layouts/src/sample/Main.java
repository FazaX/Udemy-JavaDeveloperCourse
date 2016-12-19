package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("gridPane.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("hBox.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("borderPane.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("flowPane.fxml"));
        primaryStage.setTitle("Layouts");
        primaryStage.setScene(new Scene(root, 500, 450));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
