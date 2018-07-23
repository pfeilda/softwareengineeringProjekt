package com.pfeilda.ajb.gui.Elements.Partials;

import com.pfeilda.ajb.equipment.SubstanceContainer;

import java.awt.BorderLayout;

public class GlobalGameActionButtonGroup extends AbstractPartial {
    private final SubstanceContainer substanceContainer;

    public GlobalGameActionButtonGroup(final SubstanceContainer substanceContainer) {
        this.substanceContainer = substanceContainer;
        this.initial();
    }

    @Override
    public void selectLayout() {
        this.setLayout(new BorderLayout());
    }

    @Override
    public void addComponents() {
        this.add(new SpeedButtonGroup(), BorderLayout.PAGE_START);
        this.add(new GlobalAssayActions(this.substanceContainer), BorderLayout.PAGE_END);
    }

    @Override
    public void addActionButtons() {
    }
}
