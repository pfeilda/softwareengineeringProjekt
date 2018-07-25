package com.pfeilda.ajb.gui.Elements.Buttons;

import com.pfeilda.ajb.equipment.SubstanceContainer;

import java.awt.Graphics;
import java.awt.event.ActionEvent;

public class BoilingStone extends ExternalReagentButton {
    public BoilingStone(final SubstanceContainer substanceContainer) {
        super(substanceContainer, new com.pfeilda.ajb.equipment.BoilingStone());
    }

    @Override
    protected void paintComponentIcon(final Graphics g) {
        g.setColor(this.drawColor);

        final int xOffset = 5;
        final int yOffset = 5;

        g.drawOval(xOffset + 15, yOffset + 5, 10, 10);
        g.drawOval(xOffset + 25, yOffset + 25, 10, 10);
        g.drawOval(xOffset + 5, yOffset + 25, 10, 10);
    }

    @Override
    protected void addActionListener() {
        final BoilingStone boilingStone = this;
        this.addActionListener((ActionEvent actionEvent) -> {
            boilingStone.toogleActive();
            boilingStone.repaint();
        });
    }
}
