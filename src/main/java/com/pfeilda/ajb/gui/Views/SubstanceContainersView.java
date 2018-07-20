package com.pfeilda.ajb.gui.Views;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.Elements.Partials.SubstanceContainerTab;
import com.pfeilda.ajb.gui.InitialInterface;

import javax.swing.JTabbedPane;
import java.util.ArrayList;
import java.util.List;

public class SubstanceContainersView extends JTabbedPane implements InitialInterface {
    private final List<SubstanceContainer> substanceContainers;
    private final GameView parent;
    private int count = 1;

    public SubstanceContainersView(final GameView parent, final SubstanceContainer substanceContainer) {
        this.substanceContainers = new ArrayList<>();
        if (substanceContainer != null) {
            this.substanceContainers.add(substanceContainer);
        }

        this.parent = parent;
        this.addComponents();
    }

    @Override
    public void selectLayout() {
    }

    @Override
    public void addComponents() {
        final SubstanceContainersView substanceContainersView = this;
        this.substanceContainers.forEach(substanceContainersView::add);
    }

    @Override
    public void addActionButtons() {
    }

    public final void add(final SubstanceContainer substanceContainer) {
        this.add(new SubstanceContainerTab(this, substanceContainer), String.valueOf(this.count));
        this.count++;
    }
}
