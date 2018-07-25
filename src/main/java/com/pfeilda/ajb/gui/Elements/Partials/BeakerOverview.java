package com.pfeilda.ajb.gui.Elements.Partials;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.equipment.SubstanceContainer;

import java.awt.Dimension;
import java.awt.Graphics;

public class BeakerOverview extends AssayOverview {
    public BeakerOverview(final SubstanceContainer substanceContainer, final AbstractSubstance abstractSubstance) {
        super(substanceContainer, abstractSubstance);
    }

    @Override
    public void paint(final Graphics g) {

        if (!this.abstractSubstance.hasDeposit()) {
            this.add(this.warning);
        } else {
            this.remove(this.warning);
        }
        this.warning.setVisible(true);

        super.paint(g);

        final Dimension dimension = this.getSize();

        final int width = 100;
        final int height = 150;

        final int xOffset = (int) (dimension.getWidth() - 100) / 2;
        final int yOffset = 20;


        g.drawLine(xOffset, yOffset, xOffset, yOffset + height);
        g.drawLine(xOffset, yOffset + height, xOffset + width, yOffset + height);
        g.drawLine(xOffset + width, yOffset + height, xOffset + width, yOffset);

        final int fillHeight = height - (int) (
                height *
                        this.abstractSubstance.getVolume().get() /
                        this.substanceContainer.getMaxVolume().get()
        );

        g.drawLine(xOffset, yOffset + fillHeight, xOffset + width, yOffset + fillHeight);
    }
}
