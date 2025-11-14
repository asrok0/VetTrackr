package com.example.vettrackr;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewAnimalEntryController extends AnimalPageController implements Initializable {

    @FXML
    private Button newAnimalSendButton;

    @FXML
    private Label newAnimalAgeLabel;

    @FXML
    private TextField newAnimalAgeText;

    @FXML
    private AnchorPane newAnimalAnchorPane;

    @FXML
    private BorderPane newAnimalBorderPane;

    @FXML
    private Label newAnimalDateLabel;

    @FXML
    private TextField newAnimalDateText;

    @FXML
    private Label newAnimalContactLabel;

    @FXML
    private TextField newAnimalContactText;

    @FXML
    private Label newAnimalNameLabel;

    @FXML
    private TextField newAnimalNameText;

    @FXML
    private Label newAnimalTopBar;

    @FXML
    private Label newAnimalTreatmentLabel;

    @FXML
    private TextField newAnimalTreatmentText;

    @FXML
    private Label newAnimalWeightLabel;

    @FXML
    private TextField newAnimalWeightText;

    @FXML
    private Label newAnimalOwnerLabel;

    @FXML
    private TextField newAnimalOwnerText;

    private String name;
    private String date;
    private String treatments;
    private String owner;
    private String age;
    private String weight;
    private String contact;

    private Stage stage;
    private Scene scene;

    Stage primary = new Stage();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try
            {
            Parent root = FXMLLoader.load(getClass().getResource("AnimalPage.fxml"));
            Scene scene = new Scene(root);
            primary.setScene(scene);
            }

        catch (Exception e)
            {
            e.printStackTrace();
            }

    }   //End initialize()


    @FXML
    public void newAnimalSendButtonClick(ActionEvent event) throws IOException {

        name = newAnimalNameText.getText();
        date = newAnimalDateText.getText();
        treatments = newAnimalTreatmentText.getText();
        owner = newAnimalOwnerText.getText();
        age = newAnimalAgeText.getText();
        weight = newAnimalWeightText.getText();
        contact = newAnimalContactText.getText();

        animalNameLabelStatic.setText(name);
        ownerNameLabelStatic.setText(owner);
        dateLabelStatic.setText(date);
        ageLabelStatic.setText(age);
        weightLabelStatic.setText(weight);
        treatmentsLabelStatic.setText(treatments);
        contactLabelStatic.setText(contact);

        Main.addNewAnimal(name, date, treatments, owner, age, weight, contact);

        primary.show();

    }   //End NewAnimalSendButtonClick()

}   //End Class