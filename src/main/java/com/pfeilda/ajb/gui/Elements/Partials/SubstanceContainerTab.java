package com.pfeilda.ajb.gui.Elements.Partials;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.Views.SubstanceContainersView;

import javax.swing.JOptionPane;
import java.awt.BorderLayout;

public class SubstanceContainerTab extends AbstractPartial {
    private final SubstanceContainer substanceContainer;
    private final SubstanceContainersView parent;

    public SubstanceContainerTab(
            final SubstanceContainersView parent,
            final SubstanceContainer substanceContainer
    ) {
        this.parent = parent;
        this.substanceContainer = substanceContainer;

        final SubstanceContainerTab substanceContainerTab = this;
        this.substanceContainer.addConsumerToSubstance((Object abstractSubstance) -> {
            JOptionPane.showMessageDialog(
                    substanceContainerTab,
                    "Probe wurde zerstört.",
                    "Interaktionsfehler",
                    JOptionPane.ERROR_MESSAGE
            );

            parent.remove(substanceContainerTab);
        });

        this.initial();
    }

    @Override
    public void selectLayout() {
        this.setLayout(new BorderLayout());
    }

    @Override
    public void addComponents() {
        this.add(new ReagentActions(this.substanceContainer), BorderLayout.LINE_START);
        this.add(new Properties(this.substanceContainer.getPropertiesOfSubstances()), BorderLayout.LINE_END);
    }

    @Override
    public void addActionButtons() {
        this.add(new AssayActionButtonsGroup(this.substanceContainer), BorderLayout.PAGE_END);
    }
}
