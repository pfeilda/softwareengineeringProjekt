package com.pfeilda.ajb.gui.Elements.Partials;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.Elements.Buttons.*;
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
        this.setLayout(new GridLayout(0, 2));
    }

    @Override
    public void addComponents() {

    }

    @Override
    public void addActionButtons() {
        this.add(new DivideAssayButton(this.substanceContainer, this.substanceContainersView));
        this.add(new FilterAssay(this.substanceContainer, this.substanceContainersView));
        this.add(new AddElements(this.substanceContainer));
        this.add(new OpenChangePHValueDialog(this.substanceContainer));
        this.add(new ExperimentalProof(this.substanceContainer));
        this.add(new ChangeContainer(this.substanceContainer, this.substanceContainersView));
    }
}
