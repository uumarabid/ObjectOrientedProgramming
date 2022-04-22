package com.mycompany.surgeryapplication;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Separator;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * JavaFX App
 */
public class App extends Application {
    
    private StoreList animalList;

    // WIDTH and HEIGHT of GUI
    //private final int WIDTH = 1100;
    //private final int HEIGHT = 800;
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
    // search animal field
    private Label searchAnimalNameLabel = new Label("Search animal Name");
    private TextField searchAnimalNameField = new TextField();
    private Button searchButton = new Button("search");
    
    ComboBox<String> box = new ComboBox<>();
    // tableView instance
    private TableView<Animal> table = new TableView<Animal>();
    // searched datafield
    private TextArea viewDataField = new TextArea();
    
    ScrollBar s = new ScrollBar();
    
    @Override
    public void start(Stage stage) {
        
        animalList = new StoreList(20);
        //horizontal boxes
        HBox animalDetails = new HBox(8); // spacing = 8
        HBox ownerDetails = new HBox(8);
        HBox hbTable = new HBox(8);

        //combo box
        box.getItems().addAll("Cat", "Dog", "Mouse", "Rabbit");
        box.setValue("Type of animal");

        // set columns
        // https://docs.oracle.com/javafx/2/ui_controls/table-view.htm
        TableColumn animalNameColumn = new TableColumn("Animal name");
        animalNameColumn.setMinWidth(100);
        animalNameColumn.setCellValueFactory(
                new PropertyValueFactory<Animal, String>("name"));
        
        TableColumn colourColumn = new TableColumn("Colour");
        colourColumn.setMinWidth(100);
        colourColumn.setCellValueFactory(
                new PropertyValueFactory<Animal, String>("colour"));
        
        TableColumn genderColumn = new TableColumn("Gender");
        genderColumn.setMinWidth(100);
        genderColumn.setCellValueFactory(
                new PropertyValueFactory<Animal, String>("gender"));
        
        TableColumn ageColumn = new TableColumn("Age");
        ageColumn.setMinWidth(100);
        ageColumn.setCellValueFactory(
                new PropertyValueFactory<Animal, String>("age"));
        
        TableColumn illnessColumn = new TableColumn("Illness");
        illnessColumn.setMinWidth(100);
        illnessColumn.setCellValueFactory(
                new PropertyValueFactory<Animal, String>("illnesses"));

        // ObservableList
        ObservableList<Animal> observrableList = FXCollections.observableList(animalList.loadAnimal());
        table.setItems(observrableList);

        // add columns to table
        table.getColumns().addAll(animalNameColumn, colourColumn, genderColumn, ageColumn, illnessColumn);
        addButtonToTable();

        // add components to HBoxes
        animalDetails.getChildren().addAll(box, nameLabel, nameField, colourLabel, colourField,
                genderLabel, genderField, ageLabel, ageField, illnessesLabel, illnessesField);
        ownerDetails.getChildren().addAll(giveNameLabel, giveNameField, surnameLabel, surnameField);
        hbTable.getChildren().addAll(table, searchAnimalNameLabel, searchAnimalNameField, searchButton, viewDataField);

        // vertical box
        VBox vb = new VBox(8);
        // add components to VBox
        vb.getChildren().addAll(headingLabel, sectSeparator, animallaLabel, animalDetails, sectSeparator2,
                ownerLabel, ownerDetails, sectSeparator3, displayAnimals, addButton, sectSeparator4, hbTable);

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
        //hbTable.setAlignment(Pos.CENTER);

        // VBox positioning and colour
        vb.setAlignment(Pos.CENTER);
        vb.setBackground(Background.EMPTY);

        // set minimum and maximum width of component
        displayAnimals.setMaxSize(400, 700);
        viewDataField.setMaxSize(400, 700);

//        stage.setWidth(WIDTH);
//        stage.setHeight(HEIGHT);
        stage.setMaximized(true);

        // call private methods for button event handler
        addButton.setOnAction(e -> addHandler());
        searchButton.setOnAction(e -> loadAnimalsInPage());
        
        stage.setScene(scene);
        stage.setTitle("Veterinary Surgery");
        stage.show();
    }

    //event handler
    private void addHandler() {
        try {
            String animalType = box.getValue();
            String animalName = nameField.getText();
            String animalColour = colourField.getText();
            String animalGender = genderField.getText();
            String animalIllnesses = illnessesField.getText();
            String ownerGiveName = giveNameField.getText();
            String OwnerSurname = surnameField.getText();
            //conditions
            if (animalType.length() == 0 || animalName.length() == 0 || animalColour.length() == 0 || animalGender.length() == 0
                    || ageField.getText().length() == 0 || animalIllnesses.length() == 0) {
                displayAnimals.setText("You must complete the missing animal details");
            } else if (ownerGiveName.length() == 0 || OwnerSurname.length() == 0) {
                displayAnimals.setText("You must enter both your given name and surname");
            } else {
                
                int animalAge = parseInt(ageField.getText());
                if (animalAge > 100) {
                    displayAnimals.setText("You must enter a proper age");
                } else {
                    Animal animalToAdd = new Animal(animalType, animalName, animalColour,
                            animalGender, animalAge, animalIllnesses, ownerGiveName, OwnerSurname);
                    
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
        } catch (Exception ex) {
            
        }
    }
    
    private void loadAnimalsInPage() {
        try {
            String animalSearchName = searchAnimalNameField.getText();
            
            ArrayList<Animal> searchData = animalList.loadAnimal();
            ArrayList<Animal> filteredData = new ArrayList<>();
            for (int i = 0; i < searchData.size(); i++) {
                if (searchData.get(i).name.contains(animalSearchName)) {
                    filteredData.add(searchData.get(i));
                }
            }

            // used this for reference https://docs.oracle.com/javafx/2/ui_controls/table-view.htm#:~:text=The%20TableView%20class%20provides%20built,default%2C%20no%20sorting%20is%20applied.
            // this is to convert array list to observablelist,
            // table doesn't take arraylist type
            ObservableList<Animal> observableList = FXCollections.observableList(filteredData);
            
            table.setItems(observableList);
        } catch (Exception ex) {
            
        }
    }

    // took it from https://riptutorial.com/javafx/example/27946/add-button-to-tableview#:~:text=You%20can%20add%20a%20button,setCellFactory(Callback%20value)%20method.&text=In%20this%20application%20we%20are,selected%20and%20its%20information%20printed.
    private void addButtonToTable() {
        TableColumn<Animal, Void> colBtn = new TableColumn("");
        
        Callback<TableColumn<Animal, Void>, TableCell<Animal, Void>> cellFactory
                = new Callback<TableColumn<Animal, Void>, TableCell<Animal, Void>>() {
            @Override
            public TableCell<Animal, Void> call(final TableColumn<Animal, Void> param) {
                final TableCell<Animal, Void> cell = new TableCell<Animal, Void>() {
                    private final Button btn = new Button("Action");
                    
                    {
                        btn.setOnAction((ActionEvent) -> {
                            Animal data = getTableView().getItems().get(getIndex());
                            
                            String searched
                                    = "Animal"
                                    + "\nName: " + data.name
                                    + "\nColour " + data.colour
                                    + "\nOwner"
                                    + "\nOwner Name " + data.ownerGiveName
                                    + "\nOner Surname " + data.ownerSurname;
                            viewDataField.setText(searched);
                        });
                    }
                    
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }            
            
        };
        
        colBtn.setCellFactory(cellFactory);
        
        table.getColumns().add(colBtn);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
