package com.pfeilda.ajb.gui.Elements.Buttons;

import com.pfeilda.ajb.equipment.SubstanceContainer;

import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class AuswertenButton extends JButton {
    private final SubstanceContainer substanceContainer;

    public AuswertenButton(final SubstanceContainer substanceContainer) {
        this.substanceContainer = substanceContainer;

        this.setText("Auswerten");

        this.addActionListener(this::evaluateAction);
    }

    private void evaluateAction(final ActionEvent actionEvent) {
        System.out.println(this.substanceContainer);
    }
}
