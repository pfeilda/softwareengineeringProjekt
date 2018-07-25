package com.pfeilda.ajb.gui.Views;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.Elements.Partials.GlobalGameActionButtonGroup;
import com.pfeilda.ajb.gui.ViewContainerAbstract;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class GameView extends View {
    private final SubstanceContainer urSubstanceContainer;

    //todo check if substanceContainer contains basicassay
    public GameView(final ViewContainerAbstract parent, final SubstanceContainer substanceContainer) {
        super(parent, "Spiel");
        this.urSubstanceContainer = substanceContainer;

        this.executeAfterInitial();

        this.setMinimumSize(new Dimension(400, 400));

        //todo remove this line or replace with better
        this.parent.setSize(new Dimension(500, 500));
    }

    @Override
    public void addComponents() {
        final JMenuBar jMenuBar = new JMenuBar();

        final JMenu jMenu = new JMenu("Menü");

        final JMenuItem helpItem = new JMenuItem("Hilfe");
        final JMenuItem backItem = new JMenuItem("Zurueck zum Menue");
        jMenu.add(backItem);
        jMenu.add(helpItem);

        jMenuBar.add(jMenu);

        this.parent.setJMenuBar(jMenuBar);

        this.add(new JLabel("Proben:", SwingConstants.CENTER), BorderLayout.PAGE_START);
    }

    private void executeAfterInitial() {
        this.add(new SubstanceContainersView(this, this.urSubstanceContainer));
        this.add(new GlobalGameActionButtonGroup(this.parent, this.urSubstanceContainer), BorderLayout.PAGE_END);
    }

    @Override
    public void selectLayout() {
        this.setLayout(new BorderLayout());
    }

    @Override
    public void addActionButtons() {

    }
}
