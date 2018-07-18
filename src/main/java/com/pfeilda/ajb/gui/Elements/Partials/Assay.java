package com.pfeilda.ajb.gui.Elements.Partials;

import com.pfeilda.ajb.equipment.SubstanceContainer;

import java.awt.BorderLayout;

public class Assay extends AbstractPartial {
    private final SubstanceContainer substanceContainer;

    //todo refactor
    public Assay(final SubstanceContainer substanceContainer) {
        this.substanceContainer = substanceContainer;
        this.initial();
    }

    @Override
    public void selectLayout() {
        this.setLayout(new BorderLayout());
    }


    @Override
    public void addComponents() {
        this.add(new ReagentActions(this.substanceContainer), BorderLayout.LINE_START);
        this.add(new Properties(this.substanceContainer.getPropertiesOfSubstances()), BorderLayout.LINE_END);
    }

    @Override
    public void addActionButtons() {

    }
}
