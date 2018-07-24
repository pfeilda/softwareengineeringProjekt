package com.pfeilda.ajb.gui.Elements.Partials;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.Elements.Buttons.BoilingStone;
import com.pfeilda.ajb.gui.Elements.Buttons.BunsenBurner;
import com.pfeilda.ajb.gui.Elements.Buttons.Centrifuge;

import javax.swing.BoxLayout;

public class ReagentActions extends AbstractPartial {
    private final SubstanceContainer substanceContainer;

    public ReagentActions(final SubstanceContainer substanceContainer) {
        this.substanceContainer = substanceContainer;
        this.initial();
    }

    @Override
    public void selectLayout() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void addComponents() {
        this.add(new BunsenBurner(this.substanceContainer));
        this.add(new Centrifuge(this.substanceContainer));
        this.add(new BoilingStone(this.substanceContainer));
    }

    @Override
    public void addActionButtons() {

    }
}
