package com.example.vettrackr;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomepageController extends AnimalSearchResultsController implements Initializable {

    @FXML
    private AnchorPane homeAnchorPane;

    @FXML
    private BorderPane homeBorderPane;

    @FXML
    private Button homeNewButton;

    @FXML
    private Label homeSearchLabel;

    @FXML
    private TextField homeSearchTextField;

    @FXML
    private Label homeTitleLabel;

    @FXML
    private Label homeTopBar;

    @FXML
    private Button homeSearchButton;


    private Stage stage;
    private Scene scene;

    Stage primary = new Stage();


    public String results = "";
    public String owner = "";
    public String animal = "";
    public int count = 0;

    private static ArrayList<Animal> searchList = new ArrayList<>();
    private static ArrayList<Animal> clear = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try
            {
            Parent root = FXMLLoader.load(getClass().getResource("AnimalSearchResults.fxml"));
            Scene scene = new Scene(root);
            primary.setScene(scene);
            }

        catch (Exception e)
            {
            e.printStackTrace();
            }
    }


    @FXML
    void goToNewAnimalEntryClick(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("NewAnimalEntry.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }   //End goToNewAnimalEntryClick()


    @FXML
    void searchAnimalClick(ActionEvent event) throws IOException {
        ArrayList<Animal> animals = Main.getList();

        String search = homeSearchTextField.getText();
        boolean found = false;

        for (int i = 0; i < animals.size(); i++)
            {
            if (search.equalsIgnoreCase(animals.get(i).getOwner()))
                {
                count++;

                owner = animals.get(i).getOwner();
                animal = animals.get(i).getAnimal();
                results += count + ". " + owner + " - " + animal + "\n";

                searchList.add(animals.get(i));
                found = true;
                }
            }

        count = 0;

        if (found == false)
            {
            searchResultsDisplayLabelStatic.setText("No results found, please search again!");
            }

        else
            {
            searchResultsDisplayLabelStatic.setText(results);
            }

        primary.show();
    }   //End searchAnimalClick()


    public static ArrayList<Animal> getSearchList() {
        return searchList;
    }   //End getSearchList()


    public static void clearArray() {
        searchList = clear;
    }   //End clearArray()

}   //End Class
