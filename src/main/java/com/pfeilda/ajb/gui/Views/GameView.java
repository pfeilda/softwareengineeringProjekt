package com.pfeilda.ajb.gui.Views;

import com.pfeilda.ajb.analysis.Assay;
import com.pfeilda.ajb.analysis.BasicAssay;
import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.ViewContainerAbstract;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class GameView extends View {
    private JTabbedPane assayTabs;
    private int count = 1;

    //todo check if substanceContainer contains basicassay
    public GameView(final ViewContainerAbstract parent, final SubstanceContainer substanceContainer) {
        super(parent, "Spiel");
        this.addAssay(substanceContainer);
    }

    @Override
    public void addComponents() {
        this.add(new JLabel("Proben:", SwingConstants.CENTER), BorderLayout.PAGE_START);

        this.assayTabs = new JTabbedPane();

        this.add(this.assayTabs);
    }

    public void addAssay(final SubstanceContainer substanceContainer) {

        this.assayTabs.add(
                new com.pfeilda.ajb.gui.Elements.Partials.Assay(substanceContainer),
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
