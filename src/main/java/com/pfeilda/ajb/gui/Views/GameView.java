package com.pfeilda.ajb.gui.Views;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.Elements.Partials.SpeedButtonGroup;
import com.pfeilda.ajb.gui.ViewContainerAbstract;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class GameView extends View {
    private final SubstanceContainer urSubstanceContainer;

    //todo check if substanceContainer contains basicassay
    public GameView(final ViewContainerAbstract parent, final SubstanceContainer substanceContainer) {
        super(parent, "Spiel");
        this.urSubstanceContainer = substanceContainer;

        this.addSubstanceContainers();

        //todo remove this line or replace with better
        this.parent.setSize(new Dimension(500, 500));
    }

    @Override
    public void addComponents() {
        this.add(new JLabel("Proben:", SwingConstants.CENTER), BorderLayout.PAGE_START);
        this.add(new SpeedButtonGroup(), BorderLayout.PAGE_END);
    }

    private void addSubstanceContainers() {
        this.add(new SubstanceContainersView(this, this.urSubstanceContainer));
    }

    @Override
    public void selectLayout() {
        this.setLayout(new BorderLayout());
    }

    @Override
    public void addActionButtons() {

    }
}
