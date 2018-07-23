package com.pfeilda.ajb.gui.Elements.Buttons;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.Elements.Dialog.ChangePHDialog;
import com.pfeilda.ajb.miscellaneous.PH;
import com.pfeilda.ajb.miscellaneous.Property;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;

public class ChangePHButton extends JButton {
    private final JTextField valueField;
    private final JLabel errorMessage;
    private final SubstanceContainer substanceContainer;
    private final ChangePHDialog parent;

    public ChangePHButton(
            final JTextField valueField,
            final JLabel errorMessage,
            final SubstanceContainer substanceContainer,
            final ChangePHDialog parent
    ) {
        this.valueField = valueField;
        this.errorMessage = errorMessage;
        this.substanceContainer = substanceContainer;
        this.parent = parent;

        this.setText("Aendere den Wert");

        errorMessage.setVisible(false);

        this.addActionListener(this::changeActionsListener);
    }

    private void changeActionsListener(final ActionEvent actionEvent) {
        try {
            final Double changeValue = Double.parseDouble(this.valueField.getText());

            this.parent.setVisible(false);
            this.parent.dispose();
            this.parent.setModal(false);
            System.out.println("test");

            this.substanceContainer.alter(new Property[]{
                    new PH(changeValue)
            });
        } catch (final NumberFormatException e) {
            this.errorMessage.setVisible(true);
        }
    }
}
