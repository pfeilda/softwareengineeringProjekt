package com.pfeilda.ajb.gui.Elements.Buttons;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.Elements.Dialog.AddElementDialog;

import java.awt.event.ActionEvent;

public class AddElements extends AssayActionAbstract {
    public AddElements(final SubstanceContainer substanceContainer) {
        super(substanceContainer);
        this.setText("Füge Element hinzu...");

        this.addActionListener(this::addElement);
    }

    public void addElement(final ActionEvent actionEvent) {
        new AddElementDialog(this.substanceContainer);
    }
}