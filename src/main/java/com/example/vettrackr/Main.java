package com.example.vettrackr;

import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.application.Application;

public class Main extends Application {

    private static ArrayList<Animal> animals = new ArrayList<>();


    public static void main(String[] args) {launch();}	//End main()


    @Override
    public void start(Stage stage) {

        try
            {
            Parent root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            }

        catch (Exception e)
            {
            e.printStackTrace();
            }

    }   //End start()


    public static void addNewAnimal(String name, String date, String treatments, String owner, String age, String weight, String contact) {

        Animal animal = new Animal(name, date, treatments, owner, age, weight, contact);
        animals.add(animal);

    }   //End adNewAnimal()


    public static ArrayList<Animal> getList() {
        return animals;
    }   //End getList()


}	//End Class
