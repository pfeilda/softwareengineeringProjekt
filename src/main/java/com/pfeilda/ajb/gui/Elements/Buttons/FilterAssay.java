package com.pfeilda.ajb.gui.Elements.Buttons;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.Views.SubstanceContainersView;

import java.awt.event.ActionEvent;

public class FilterAssay extends AssayActionAbstract {
    private final SubstanceContainersView substanceContainersView;

    public FilterAssay(final SubstanceContainer substanceContainer, final SubstanceContainersView substanceContainersView) {
        super(substanceContainer);
        this.substanceContainersView = substanceContainersView;

        this.setText("Probe filtrieren");

        this.addActionListener(this::divideAction);
    }

    private void divideAction(final ActionEvent actionEvent) {
        final SubstanceContainer substanceContainer = this.substanceContainer.divideWithDeposit();
        if (substanceContainer != null)
            this.substanceContainersView.add(substanceContainer);
    }
}
