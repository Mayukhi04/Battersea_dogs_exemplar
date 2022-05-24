package com.company;

import com.company.Dog;
import com.company.FileHandler;

import java.util.ArrayList;

public class Kennels {
    // contains all the dogs

    private ArrayList<Dog> allDogs;
    private String databaseFileName;

    public Kennels(String filename) {
        databaseFileName = filename;
        allDogs = new ArrayList<>();

        ArrayList<String> dogRecords = FileHandler.readWholeFile(filename);
        for (String record: dogRecords) {
            Dog d = new Dog(record);
            allDogs.add(d);
        }
    }

    public void display() {
        for (Dog d: allDogs) {
            d.display();
        }
        System.out.println("Total dogs:" + allDogs.size() + "\n");
    }

    public void add(String name, int age, String breed) {
        // add a new dog to the kennels
        // new additions have a stayLength of 0, by definition
        allDogs.add(new Dog(name, age, breed, 0));
    }

    public void save() {
        // write out all the dogs records to a CSV file
        FileHandler.writeLine(databaseFileName, "Name,Age,Breed,Stay Length", false);
        for (Dog d: allDogs) {
            FileHandler.writeLine(databaseFileName, d.toString(), true);
        }
    }

    public Dog getDog(int recordNumber) {
        if (recordNumber < allDogs.size()) {
            return allDogs.get(recordNumber);
        } else {
            return null;
        }
    }

    public int getTotalDogs() {
        return allDogs.size();
    }
}

