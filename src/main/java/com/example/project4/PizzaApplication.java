package com.example.project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main controller for application, opens MainMenuView
 * @author Palak Singh, Daniel Guan
 */
public class PizzaApplication extends Application {

    /**
     * Start the program, first opens MainMenuView.fxml
     * @param stage Main Menu
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PizzaApplication.class.getResource("MainMenuView.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 625, 425);
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}