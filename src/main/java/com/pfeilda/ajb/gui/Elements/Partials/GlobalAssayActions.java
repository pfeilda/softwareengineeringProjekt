package com.pfeilda.ajb.gui.Elements.Partials;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.Elements.Buttons.AuswertenButton;

import javax.swing.JButton;

public class GlobalAssayActions extends AbstractPartial {
    private final SubstanceContainer substanceContainer;

    public GlobalAssayActions(final SubstanceContainer substanceContainer) {
        this.substanceContainer = substanceContainer;

        this.initial();
    }

    @Override
    public void selectLayout() {

    }

    @Override
    public void addComponents() {

    }

    @Override
    public void addActionButtons() {
        this.add(new AuswertenButton(this.substanceContainer));
        this.add(new JButton("test"));
    }
}
