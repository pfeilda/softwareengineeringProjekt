package com.pfeilda.ajb.gui.Elements.Buttons;

import com.pfeilda.ajb.equipment.SubstanceContainer;

import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class AddElement extends JButton {
    private final SubstanceContainer substanceContainer;

    public AddElement(final SubstanceContainer substanceContainer) {
        this.setText("Füge Element hinzu...");

        this.substanceContainer = substanceContainer;

        this.addActionListener(this::addElement);
    }

    public void addElement(final ActionEvent actionEvent) {
        System.out.println("testr");
    }
}