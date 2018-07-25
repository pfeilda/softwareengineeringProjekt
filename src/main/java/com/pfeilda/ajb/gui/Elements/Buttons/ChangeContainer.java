package com.pfeilda.ajb.gui.Elements.Buttons;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.Views.SubstanceContainersView;

import javax.swing.JButton;

public class ChangeContainer extends JButton {
    public ChangeContainer(
            final SubstanceContainer substanceContainer,
            final SubstanceContainersView substanceContainersView
    ) {
        this.setText("Aendere das Behaeltniss...");
    }
}
