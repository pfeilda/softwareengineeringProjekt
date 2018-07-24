package com.pfeilda.ajb.gui.Elements.Partials;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.ViewContainerAbstract;

import java.awt.BorderLayout;

public class GlobalGameActionButtonGroup extends AbstractPartial {
    private final SubstanceContainer substanceContainer;
    private final ViewContainerAbstract viewContainerAbstract;

    public GlobalGameActionButtonGroup(final ViewContainerAbstract viewContainerAbstract, final SubstanceContainer substanceContainer) {
        this.viewContainerAbstract = viewContainerAbstract;
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
        this.add(new GlobalAssayActions(this.viewContainerAbstract, this.substanceContainer), BorderLayout.PAGE_END);
    }

    @Override
    public void addActionButtons() {
    }
}
