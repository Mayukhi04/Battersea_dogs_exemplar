package com.company;

public class Main {

   public static void main(String[] args) {
       // create the kennels object from the text file
       Kennels batterseaDogsHome = new Kennels("stray_dogs.txt");
       batterseaDogsHome.display();

       KennelGUI gui = new KennelGUI("DOG DB", batterseaDogsHome);

       // add a new dog to the home
       //batterseaDogsHome.add("Blinky", 4, "?", "brown");
       //batterseaDogsHome.display();

       // save the records to file
       //batterseaDogsHome.save("stray_dogs_new.txt");
   }
}

