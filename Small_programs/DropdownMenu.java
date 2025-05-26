package com.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropdownMenu extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new DropdownMenu();
    }

    JComboBox comboBox;

    DropdownMenu() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        String[] animals = {"dog", "cat", "bird"};
        // Integer [] numbers = {1, 2, 3}; Use Wrapper class
        comboBox = new JComboBox(animals);
        // comboBox.setEditable(true); Write in the text box
        // comboBox.addItem("horse"); Adds item to the end of the choices
        // comboBox.insertItemAt("pig", 0); Adds item to an index
        // comboBox.removeItemAt(0); Removes items at index
        // comboBox.removeItem("cat"); Remove item from list
        // comboBox.removeAllItems(); Removes all items
        // comboBox.setSelectedIndex(1); Set selected item
        // System.out.println(comboBox.getItemCount()); How many choices I have
        comboBox.addActionListener(this);

        this.add(comboBox);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
            System.out.println(comboBox.getSelectedItem());
            System.out.println(comboBox.getSelectedIndex());
        }
    }
}
