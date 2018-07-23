package com.pfeilda.ajb.gui.Elements.Buttons;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.Elements.Dialog.AddElementDialog;

import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class AddElements extends JButton {
    private final SubstanceContainer substanceContainer;

    public AddElements(final SubstanceContainer substanceContainer) {
        this.setText("Füge Element hinzu...");

        this.substanceContainer = substanceContainer;

        this.addActionListener(this::addElement);
    }

    public void addElement(final ActionEvent actionEvent) {
        new AddElementDialog(this.substanceContainer);
    }
}