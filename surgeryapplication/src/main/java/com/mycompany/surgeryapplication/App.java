package com.mycompany.surgeryapplication;

import static java.lang.Integer.parseInt;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private StoreList animalList;

    // WIDTH and HEIGHT of GUI
    private final int WIDTH = 1100;
    private final int HEIGHT = 800;
    // visual components
    private Label headingLabel = new Label("Book in your animal"); // main heading
    private Label animallaLabel = new Label("Animal details"); // sub heading
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
        
        //combo box
        ComboBox<String> box = new ComboBox<>();
        box.getItems().addAll("Cat", "Dog", "Mouse", "Rabit");

        // add components to HBoxes
        animalDetails.getChildren().addAll(box,nameLabel, nameField, colourLabel, colourField,
                genderLabel, genderField, ageLabel, ageField, illnessesLabel, illnessesField);
        ownerDetails.getChildren().addAll(giveNameLabel, giveNameField, surnameLabel, surnameField);

        // vertical box
        VBox vb = new VBox(8);
        // add components to VBox
        vb.getChildren().addAll(headingLabel, sectSeparator, animallaLabel, animalDetails, sectSeparator2,
                ownerLabel, ownerDetails, sectSeparator3, displayAnimals, sectSeparator4, addButton);

        // create the scene
        Scene scene = new Scene(vb, Color.web("#c1c1f0"));

        // set headings font
        Font font = new Font("MuseoSans", 45);
        headingLabel.setFont(font);
        font = new Font("MuseoSans", 30);
        animallaLabel.setFont(font);
        ownerLabel.setFont(font);

        // HBox elements positioning 
        animalDetails.setAlignment(Pos.CENTER);
        ownerDetails.setAlignment(Pos.CENTER);
        addButton.setAlignment(Pos.CENTER);

        // VBox positioning and colour
        vb.setAlignment(Pos.CENTER);
        vb.setBackground(Background.EMPTY);

        // set minimum and maximum width of component
        displayAnimals.setMaxSize(400, 700);

        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);

        // call private methods for button event handler
        addButton.setOnAction(e -> addHandler());

        stage.setScene(scene);
        stage.setTitle("Veterinary Surgery");
        stage.show();
    }

    //event handler
    private void addHandler() {
        String animalName = nameField.getText();
        String animalColour = colourField.getText();
        String animalGender = genderField.getText();
        String animalIllnesses = illnessesField.getText();
        String ownerGiveName = giveNameField.getText();
        String OwnerSurname = surnameField.getText();
        //conditions
        if (animalName.length() == 0 || animalColour.length() == 0 || animalGender.length() == 0
                || ageField.getText().length() == 0 || animalIllnesses.length() == 0) {
            displayAnimals.setText("You must fill in all the details regarding animal");
        } else if (ownerGiveName.length() == 0 || OwnerSurname.length() == 0) {
            displayAnimals.setText("You must enter both your given name and surname");
        } else {

            int animalAge = parseInt(ageField.getText());
            Animal animalToAdd = new Animal(animalName, animalColour, animalGender, animalAge, animalIllnesses, ownerGiveName, OwnerSurname);

            animalList.addAnimal(animalToAdd);
            animalList.saveAnimals();
            nameField.setText("");
            colourField.setText("");
            genderField.setText("");
            ageField.setText("");
            illnessesField.setText("");
            giveNameField.setText("");
            surnameField.setText("");
            displayAnimals.setText("");
            displayAnimals.appendText(animalName + " successfully added");
            displayAnimals.appendText("\n\nThe animals currently awaiting check-up are:");
            displayAnimals.appendText(animalList.displayAnimals());

        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
