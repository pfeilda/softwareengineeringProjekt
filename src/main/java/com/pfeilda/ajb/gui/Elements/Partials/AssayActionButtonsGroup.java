package com.pfeilda.ajb.gui.Elements.Partials;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.Elements.Buttons.AddElement;

import java.awt.GridLayout;

public class AssayActionButtonsGroup extends AbstractPartial {
    private final SubstanceContainer substanceContainer;

    public AssayActionButtonsGroup(final SubstanceContainer substanceContainer) {
        this.substanceContainer = substanceContainer;

        this.initial();
    }

    @Override
    public void selectLayout() {
        this.setLayout(new GridLayout(1, 3));
    }

    @Override
    public void addComponents() {

    }

    @Override
    public void addActionButtons() {
        this.add(new AddElement(this.substanceContainer));
    }
}
