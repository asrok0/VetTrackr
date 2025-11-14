package com.example.vettrackr;

public class Animal {

    private String name;
    private String date;
    private String treatments;
    private String owner;
    private String age;
    private String weight;
    private String contact;


    public Animal() {
        name = "";
        date = "";
        treatments = "";
        owner = "";
        age = "";
        weight = "";
        contact = "";
    }	//End default com.example.vettrackr.Animal()


    public Animal(String n, String d, String t, String o, String a, String w, String c) {
        name = n;
        date = d;
        treatments = t;
        owner = o;
        age = a;
        weight = w;
        contact = c;
    }	//End com.example.vettrackr.Animal()


    public String getAnimal() {return name;}
    public String getDate() {return date;}
    public String getTreatments() {return treatments;}
    public String getOwner() {return owner;}
    public String getAge() {return age;}
    public String getWeight() {return weight;}
    public String getContact() {return contact;}

}	//End Class