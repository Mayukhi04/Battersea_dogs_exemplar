package com.company;

public class Dog {
    private String name;
    private int age;
    private String breed;
    private int stayLength;

    public Dog(String name, int age, String breed, int stayLength) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.stayLength = stayLength;
    }

    public Dog(String record) {
        // construct from a comma-separated string containing all fields
        String[] fields = record.split(",");
        name = fields[0];
        age = Integer.parseInt(fields[1]);
        breed = fields[2];
        stayLength = Integer.parseInt(fields[3]);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    public int getStayLength() {
        return stayLength;
    }

    public String toString() {
        // printable string representation
        String representation =
                name + "," +
                        Integer.toString(age) + "," +
                        breed + "," +
                        Integer.toString(stayLength);
        return representation;
    }

    public void display() {
        // print fields to console
        System.out.println(toString());
    }
}
