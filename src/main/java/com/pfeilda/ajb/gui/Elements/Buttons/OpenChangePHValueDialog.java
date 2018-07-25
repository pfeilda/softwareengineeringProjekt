package com.pfeilda.ajb.gui.Elements.Buttons;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.Elements.Dialog.ChangePHDialog;

import java.awt.event.ActionEvent;

public class OpenChangePHValueDialog extends AssayActionAbstract {
    public OpenChangePHValueDialog(final SubstanceContainer substanceContainer) {
        super(substanceContainer);

        this.setText("Aendere PH Wert...");

        this.addActionListener(this::addPHDialog);
    }

    private void addPHDialog(final ActionEvent actionEvent) {
        new ChangePHDialog(this.substanceContainer);
    }
}
