package com.company;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddGUI implements ActionListener, DocumentListener {
    private Kennels kennels;

    private final int FRAME_WIDTH = 400;
    private final int FRAME_HEIGHT = 250;
    private final int LEFT_MARGIN = 10;
    private final int TAB1 = 100;
    private final int TOP_MARGIN = 20;
    private final int BUTTON_Y = 150;
    private final int BUTTON_WIDTH = 100;
    private final int BUTTON_HEIGHT = 40;
    private final int TEXT_WIDTH = 200;
    private final int TEXT_HEIGHT = 30;

    private JFrame frame;
    private JTextField nameField;
    private JTextField ageField;
    private JButton addButton;

    public AddGUI(Kennels kennels) {
        this.kennels = kennels;
        frame = new JFrame("Add new record");

        // Field labels
        JLabel label1 = new JLabel("Name:");
        label1.setBounds(LEFT_MARGIN, TOP_MARGIN, TEXT_WIDTH, TEXT_HEIGHT);
        frame.add(label1);
        JLabel label2 = new JLabel("Age:");
        label2.setBounds(LEFT_MARGIN, TOP_MARGIN + TEXT_HEIGHT, TEXT_WIDTH, TEXT_HEIGHT);
        frame.add(label2);

        // Input text fields
        nameField = new JTextField();
        nameField.setBounds(TAB1, TOP_MARGIN, TEXT_WIDTH, TEXT_HEIGHT);
        nameField.getDocument().addDocumentListener(this);
        frame.add(nameField);
        ageField = new JTextField();
        ageField.setBounds(TAB1, TOP_MARGIN+TEXT_HEIGHT, TEXT_WIDTH, TEXT_HEIGHT);
        ageField.getDocument().addDocumentListener(this);
        frame.add(ageField);

        // add button
        addButton = new JButton("Add");
        addButton.setBounds(TAB1 , BUTTON_Y, BUTTON_WIDTH*2, BUTTON_HEIGHT);
        addButton.addActionListener(this);
        addButton.setEnabled(true);
        frame.add(addButton);

        // other frame attributes
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setVisible(false);
    }

    public void show() {
        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add")) {
            // create a new dog record in the kennels from the current text fields
            kennels.add(
                    nameField.getText(),
                    Integer.parseInt(ageField.getText()),
                    "?");
        }
        hide();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // triggers when the style of the text changes
        System.out.println("change!");
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        System.out.println("remove!");
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        System.out.println("insert! ");
    }
}
