package com.company;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {

    public static ArrayList<String> readWholeFile(String fileName) {
        // read and print out the contents of a text file
        // using all the exception handling best practices

        ArrayList<String> allLines = new ArrayList<>();
        String nextLine;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            nextLine = br.readLine();  // skip header line
            nextLine = br.readLine();
            while (nextLine != null) {
                allLines.add(nextLine);
                nextLine = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return allLines;
    }

    public static void writeLine(String fileName, String text, boolean append) {
        // write text to fileName
        // either overwriting (append = false)
        // or appending (append = true)
        // using all the exception handling best practices

        try (PrintWriter pr = new PrintWriter(new FileWriter(fileName, append))) {
            pr.println(text);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
