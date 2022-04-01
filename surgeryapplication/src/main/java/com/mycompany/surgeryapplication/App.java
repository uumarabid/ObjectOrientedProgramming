package com.mycompany.surgeryapplication;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private StoreList animalList;

    // WIDTH and HEIGHT of GUI
    private final int WIDTH = 1000;
    private final int HEIGHT = 800;
    // visual components
    private Label headingLabel = new Label("Book in your animal"); // main heading
    private Label animalleLabel = new Label("Animal details"); // sub heading
    private Label nameLabel = new Label("Name");
    private TextField nameField = new TextField();
    private Label colourLabel = new Label("Colour");
    private TextField colourField = new TextField();
    private Label genderLabel = new Label("Gender");
    private TextField genderField = new TextField();
    private Label ageLabel = new Label("Age");
    private TextField ageField = new TextField();
    private Label illnessesLabel = new Label("Illnesses");
    private TextField illnessesField = new TextField();
    private Separator sectSeparator = new Separator();
    private Separator sectSeparator2 = new Separator();
    private Separator sectSeparator3 = new Separator();
    private Separator sectSeparator4 = new Separator();
    private Label ownerLabel = new Label("Owner Details"); // sub heading
    private Label giveNameLabel = new Label("Given Name");
    private TextField giveNameField = new TextField();
    private Label surnameLabel = new Label("Surname");
    private TextField surnameField = new TextField();
    private TextArea displayAnimals = new TextArea();
    private Button addButton = new Button("Book in Animal");

    @Override
    public void start(Stage stage) {

        animalList = new StoreList(20);
        //horizontal boxes
        HBox animalDetails = new HBox(8); // spacing = 8
        HBox ownerDetails = new HBox(8);
        
        // add components to HBoxes
        animalDetails.getChildren().addAll(nameLabel, nameField, colourLabel, colourField, 
                genderLabel, genderField, ageLabel, ageField, illnessesLabel, illnessesField);
        ownerDetails.getChildren().addAll(giveNameLabel, giveNameField, surnameLabel, surnameField);
        
        // vertical box
        VBox vb = new VBox(8);
        // add components to VBox
        vb.getChildren().addAll(headingLabel, sectSeparator, animalleLabel, animalDetails, sectSeparator2, 
                ownerLabel, ownerDetails, sectSeparator3, displayAnimals, sectSeparator4, addButton);
        
        

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
