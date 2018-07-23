package com.pfeilda.ajb.gui.Elements.Buttons;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.Views.SubstanceContainersView;

import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class DivideAssayButton extends JButton {
    private final SubstanceContainersView substanceContainersView;
    private final SubstanceContainer substanceContainer;
//    private final SubstanceContainerTab substanceContainerTab;

    public DivideAssayButton(final SubstanceContainersView substanceContainersView, final SubstanceContainer substanceContainer) {
        this.substanceContainersView = substanceContainersView;
        this.substanceContainer = substanceContainer;

        this.setText("Probe teilen");

        this.addActionListener(this::divideAction);
    }

    private void divideAction(final ActionEvent actionEvent) {
        final SubstanceContainer substanceContainer = this.substanceContainer.divide();
        if (substanceContainer != null)
            this.substanceContainersView.add(substanceContainer);
    }
}
