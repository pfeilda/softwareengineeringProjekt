package com.pfeilda.ajb.gui.Elements.Partials;

import com.pfeilda.ajb.analysis.Assay;

import javax.swing.BoxLayout;

public class ReagentActions extends AbstractPartial {
    private final Assay assay;

    public ReagentActions(final Assay assay) {
        this.assay = assay;
        this.initial();
    }

    @Override
    public void selectLayout() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void addComponents() {
    }

    @Override
    public void addActionButtons() {

    }
}
