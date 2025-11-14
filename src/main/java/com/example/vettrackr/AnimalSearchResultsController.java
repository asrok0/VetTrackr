package com.example.vettrackr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AnimalSearchResultsController extends AnimalPageController implements Initializable {

    @FXML
    private AnchorPane searchResultsAnchorPane;

    @FXML
    private BorderPane searchResultsBorderPane;

    @FXML
    private Label searchResultsDisplayLabel;

    @FXML
    private Label searchResultsTopBar;

    @FXML
    private TextField searchSelectBox;

    @FXML
    private Button searchSelectButton;

    @FXML
    private Label searchSelectLabel;

    @FXML
    private Button searchResultsBackToHomepage;

    @FXML
    private Label searchResultsCannotFindLabel;

    @FXML
    public static Label searchResultsDisplayLabelStatic;

    private Stage stage;
    private Scene scene;

    Stage primary = new Stage();


    int choice = -1;

    private String name;
    private String date;
    private String treatments;
    private String owner;
    private String age;
    private String weight;
    private String contact;

    private static ArrayList<Animal> clear = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        searchResultsDisplayLabelStatic = searchResultsDisplayLabel;

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
    void searchSelectButtonClick(ActionEvent event) {

        choice = Integer.parseInt(searchSelectBox.getText());

        ArrayList<Animal> animals = HomepageController.getSearchList();

        if (choice <= 0 || choice > animals.size())
            {
            searchResultsCannotFindLabel.setText("Please select a choice from the list!");
            }

        else
            {
                Animal displayAnimal = animals.get(choice-1);

                name = displayAnimal.getAnimal();
                date = displayAnimal.getDate();
                treatments = displayAnimal.getTreatments();
                owner = displayAnimal.getOwner();
                age = displayAnimal.getAge();
                weight = displayAnimal.getWeight();
                contact = displayAnimal.getContact();

                HomepageController.clearArray();
                animals = clear;

                animalNameLabelStatic.setText(name);
                ownerNameLabelStatic.setText(owner);
                dateLabelStatic.setText(date);
                ageLabelStatic.setText(age);
                weightLabelStatic.setText(weight);
                treatmentsLabelStatic.setText(treatments);
                contactLabelStatic.setText(contact);

                primary.show();
            }



    }   //End searchSelectButtonClick()


    @FXML
    void searchResultsBackToHomepageClick(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }   //End searchResultsBackToHomepageClick()

}   //End Class