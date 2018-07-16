package com.pfeilda.ajb.gui.Elements.Partials;

import java.awt.BorderLayout;

public class Assay extends AbstractPartial {
    private final com.pfeilda.ajb.analysis.Assay assay;

    //todo refactor
    public Assay(final com.pfeilda.ajb.analysis.Assay assay) {
        this.assay = assay;
        this.initial();
    }

    @Override
    public void selectLayout() {
        this.setLayout(new BorderLayout());
    }


    @Override
    public void addComponents() {
        this.add(new Properties(this.assay.getProperties()), BorderLayout.LINE_END);
    }

    @Override
    public void addActionButtons() {

    }
}
