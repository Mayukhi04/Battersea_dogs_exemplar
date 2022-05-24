package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KennelGUI implements ActionListener {
    private Kennels kennels;
    private int currentRecord;

    private final int FRAME_WIDTH = 400;
    private final int FRAME_HEIGHT = 500;
    private final int LEFT_MARGIN = 100;
    private final int TOP_MARGIN = 20;
    private final int BUTTON_Y = 150;
    private final int BUTTON_WIDTH = 100;
    private final int BUTTON_HEIGHT = 40;
    private final int TEXT_WIDTH = 200;
    private final int TEXT_HEIGHT = 30;

    private JFrame frame;
    private AddGUI addForm;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JButton previousButton;
    private JButton nextButton;
    private JButton addButton;
    private JButton saveButton;

    public KennelGUI(String name, Kennels kennels) {
        this.kennels = kennels;
        currentRecord = 0;
        frame = new JFrame(name);

        // Field labels
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(LEFT_MARGIN, TOP_MARGIN, TEXT_WIDTH, TEXT_HEIGHT);
        frame.add(nameLabel);
        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(LEFT_MARGIN, TOP_MARGIN+TEXT_HEIGHT, TEXT_WIDTH, TEXT_HEIGHT);
        frame.add(ageLabel);

        // previous button
        previousButton = new JButton("<");
        previousButton.setBounds(LEFT_MARGIN, BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        previousButton.addActionListener(this);
        previousButton.setEnabled(false);
        frame.add(previousButton);

        // next button
        nextButton = new JButton(">");
        nextButton.setBounds(LEFT_MARGIN + BUTTON_WIDTH, BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        nextButton.addActionListener(this);
        nextButton.setEnabled(true);
        frame.add(nextButton);

        // add button
        addButton = new JButton("New");
        addButton.setBounds(LEFT_MARGIN , BUTTON_Y + BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT);
        addButton.addActionListener(this);
        addButton.setEnabled(true);
        frame.add(addButton);

        // save button
        saveButton = new JButton("Save");
        saveButton.setBounds(LEFT_MARGIN + BUTTON_WIDTH , BUTTON_Y+BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT);
        saveButton.addActionListener(this);
        saveButton.setEnabled(true);
        frame.add(saveButton);

        // grab first record
        displayRecord(currentRecord);

        // other frame attributes
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setVisible(true);

        // create the edit form but keep it invisible for now
        addForm = new AddGUI(this.kennels);
    }

    private void displayRecord(int recordNumber) {
        // populate the form with the data for a particular dog
        Dog dog = kennels.getDog(recordNumber);
        if (dog != null) {
            nameLabel.setText("Name: " + dog.getName());
            ageLabel.setText("Age: " + dog.getAge());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(">")) {
            currentRecord++;
            displayRecord(currentRecord);
            previousButton.setEnabled(true);
            if (currentRecord >= kennels.getTotalDogs() -1) {
                currentRecord = kennels.getTotalDogs() -1;
                nextButton.setEnabled(false);
            }
        }
        if (e.getActionCommand().equals("<")) {
            currentRecord--;
            displayRecord(currentRecord);
            nextButton.setEnabled(true);
            if (currentRecord <= 0) {
                currentRecord = 0;
                previousButton.setEnabled(false);
            }
        }
        if (e.getActionCommand().equals("New")) {
            addForm.show();
        }
        if (e.getActionCommand().equals("Save")) {
            kennels.save();
        }
    }

}

