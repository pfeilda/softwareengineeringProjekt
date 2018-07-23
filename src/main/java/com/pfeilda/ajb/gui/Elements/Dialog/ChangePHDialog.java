package com.pfeilda.ajb.gui.Elements.Dialog;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.Elements.Buttons.ChangePHButton;
import com.pfeilda.ajb.miscellaneous.PH;

import javax.swing.*;
import java.awt.Dimension;

public class ChangePHDialog extends JDialog {
    public ChangePHDialog(final SubstanceContainer substanceContainer) {
        this.setTitle("Aendere PH Wert");

        final JPanel changeContainer = new JPanel();
        changeContainer.setLayout(new BoxLayout(changeContainer, BoxLayout.Y_AXIS));
        final JTextField valueField = new JTextField();
        final JLabel errorMessage = new JLabel(
                "Bitte gib eine Zahl zwischen -" + PH.max + " und " + PH.max + " ein!"
        );
        changeContainer.add(new JLabel("Erhoehe oder verringere den PH Wert um:"));
        changeContainer.add(valueField);
        changeContainer.add(new ChangePHButton(valueField, errorMessage, substanceContainer, this));
        changeContainer.add(errorMessage);

        this.add(changeContainer);

        this.setModal(true);
        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(
                WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
