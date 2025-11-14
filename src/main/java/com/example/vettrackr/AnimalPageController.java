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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AnimalPageController implements Initializable {

    @FXML
    private Label animalPageAgeChangeLabel;

    @FXML
    private Label animalPageAgeSetLabel;

    @FXML
    private Label animalPageContactChangeLabel;

    @FXML
    private Label animalPageContactSetLabel;

    @FXML
    private AnchorPane animalPageAnchorPane;

    @FXML
    private BorderPane animalPageBorderPane;

    @FXML
    private Label animalPageDateChangeLabel;

    @FXML
    private Label animalPageDateSetLabel;

    @FXML
    private Label animalPageNameChangeLabel;

    @FXML
    private Label animalPageNameSetLabel;

    @FXML
    private Label animalPageOwnerChangeLabel;

    @FXML
    private Label animalPageOwnerSetLabel;

    @FXML
    private Button animalPageToHomeButton;

    @FXML
    private Label animalPageTopBar;

    @FXML
    private Label animalPageTreatmentsChangeLabel;

    @FXML
    private Label animalPageTreatmentsSetLabel;

    @FXML
    private Button animalPageViewFileButton;

    @FXML
    private Label animalPageWeightChangeLabel;

    @FXML
    private Label animalPageWeightSetLabel;

    @FXML
    private Label fileDownloadedLabel;


    private Stage stage;
    private Scene scene;

    public static Label animalNameLabelStatic;
    public static Label ownerNameLabelStatic;
    public static Label dateLabelStatic;
    public static Label ageLabelStatic;
    public static Label weightLabelStatic;
    public static Label treatmentsLabelStatic;
    public static Label contactLabelStatic;


    @FXML
    void animalPageToHomeClick(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }   //End animalPageToHomeClick()


    @FXML
    void animalPageViewFileClick(ActionEvent event) throws IOException {

        fileClearing();

        String animalName = animalNameLabelStatic.getText();
        String ownerName = ownerNameLabelStatic.getText();
        String date = dateLabelStatic.getText();
        String age = ageLabelStatic.getText();
        String weight = weightLabelStatic.getText();
        String treatments = treatmentsLabelStatic.getText();
        String contact = contactLabelStatic.getText();

        filePrinting(animalName, ownerName, date, age, weight, treatments, contact);

        fileDownloadedLabel.setText("File created");

    }   //End animalPageViewFileClick()


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        animalNameLabelStatic = animalPageNameChangeLabel;
        ownerNameLabelStatic = animalPageOwnerChangeLabel;
        dateLabelStatic = animalPageDateChangeLabel;
        ageLabelStatic = animalPageAgeChangeLabel;
        weightLabelStatic = animalPageWeightChangeLabel;
        treatmentsLabelStatic = animalPageTreatmentsChangeLabel;
        contactLabelStatic = animalPageContactChangeLabel;

    }   //End initialize()


    public void filePrinting(String animalName, String ownerName, String date, String age, String weight, String treatments, String contact) throws IOException {

        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        File print = new File("Receipt.txt");

        Scanner fileInput = new Scanner(print);

        try
            {
            fw = new FileWriter(print);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.print("VetTrackr Generated Receipt\n");

            loopPrint(pw);

            pw.print("\nOwner Name: " + ownerName + "\nOwner Contact: " + contact + "\n\nAnimal Name: " + animalName + "\n\nDate of Admittance: " + date + "\n\nAnimal Age: " + age + "\nAnimal Weight: " + weight + "\nTreatment(s): " + treatments + "\n");

            loopPrint(pw);

            pw.print("\nThank you or choosing VetTrackr!");

            pw.flush();
            }

        finally
            {
            try
                {
                pw.close();
                bw.close();
                fw.close();
                }

            catch(IOException io) {}
            }

    }   //End filePrinting()


    public void fileClearing() throws IOException {

        File print = new File("Receipt.txt");

        FileWriter fw = new FileWriter(print);
        PrintWriter pw = new PrintWriter(fw);

        pw.print("");

        pw.close();
        fw.close();

    }   //End fileClearing()


    public void loopPrint(PrintWriter pw) {
        for (int i = 0; i < 65; i++)
            {
            pw.print("-");
            }
    }   //End loopPrint()

}   //End Class
