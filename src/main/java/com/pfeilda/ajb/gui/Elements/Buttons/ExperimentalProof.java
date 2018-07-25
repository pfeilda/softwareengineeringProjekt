package com.pfeilda.ajb.gui.Elements.Buttons;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.Elements.Dialog.ExperimentalProofDialog;

import java.awt.event.ActionEvent;

public class ExperimentalProof extends AssayActionAbstract {
    public ExperimentalProof(
            final SubstanceContainer substanceContainer
    ) {
        super(substanceContainer);

        this.setText("Einzelnachweis...");

        this.addActionListener(this::divideAction);
    }

    private void divideAction(final ActionEvent actionEvent) {
        new ExperimentalProofDialog(this.substanceContainer);
    }
}
