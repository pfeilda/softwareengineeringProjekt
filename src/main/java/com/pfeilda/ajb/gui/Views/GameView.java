package com.pfeilda.ajb.gui.Views;

import com.pfeilda.ajb.analysis.Assay;
import com.pfeilda.ajb.analysis.BasicAssay;
import com.pfeilda.ajb.gui.ViewContainerAbstract;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class GameView extends View {
    private JTabbedPane assayTabs;
    private int count = 1;

    public GameView(final ViewContainerAbstract parent, final BasicAssay basicAssay) {
        super(parent, "Spiel");
        this.addAssay(basicAssay);
    }

    @Override
    public void addComponents() {
        this.add(new JLabel("Proben:", SwingConstants.CENTER), BorderLayout.PAGE_START);

        this.assayTabs = new JTabbedPane();

        this.add(this.assayTabs);
    }

    public void addAssay(final Assay assay) {

        this.assayTabs.add(
                new com.pfeilda.ajb.gui.Elements.Partials.Assay(assay),
                (this.count++) + ""
        );
    }

    @Override
    public void selectLayout() {
        this.setLayout(new BorderLayout());
    }

    @Override
    public void addActionButtons() {

    }
}
