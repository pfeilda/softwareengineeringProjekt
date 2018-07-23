package com.pfeilda.ajb.gui.Elements.Partials;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.Elements.Buttons.AddElements;
import com.pfeilda.ajb.gui.Elements.Buttons.DivideAssayButton;
import com.pfeilda.ajb.gui.Views.SubstanceContainersView;

import java.awt.GridLayout;

public class AssayActionButtonsGroup extends AbstractPartial {
    private final SubstanceContainer substanceContainer;
    private final SubstanceContainersView substanceContainersView;

    public AssayActionButtonsGroup(
            final SubstanceContainer substanceContainer,
            final SubstanceContainersView substanceContainersView
    ) {
        this.substanceContainer = substanceContainer;
        this.substanceContainersView = substanceContainersView;

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
        this.add(new AddElements(this.substanceContainer));
        this.add(new DivideAssayButton(this.substanceContainersView, this.substanceContainer));
    }
}
