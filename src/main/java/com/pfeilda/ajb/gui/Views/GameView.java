package com.pfeilda.ajb.gui.Views;

import com.pfeilda.ajb.analysis.BasicAssay;
import com.pfeilda.ajb.gui.ViewContainerAbstract;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.util.HashSet;
import java.util.Set;

public class GameView extends View {
    private final Set<BasicAssay> assays = new HashSet();

    public GameView(final ViewContainerAbstract parent, final BasicAssay basicAssay) {
        super(parent, "Spiel");
        this.assays.add(basicAssay);
    }

    @Override
    protected void addComponents() {
        this.add(new JLabel("Proben:", SwingConstants.CENTER), BorderLayout.PAGE_START);

        final JTabbedPane assayTabs = new JTabbedPane();

        assayTabs.addTab("1", new StartGameView(this.parent));

        this.add(assayTabs);
    }

    @Override
    protected void selectLayout() {

    }

    @Override
    protected void addActionButtons() {

    }
}
