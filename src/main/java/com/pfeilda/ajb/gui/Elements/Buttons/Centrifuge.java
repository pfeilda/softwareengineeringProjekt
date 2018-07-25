package com.pfeilda.ajb.gui.Elements.Buttons;

import com.pfeilda.ajb.equipment.SubstanceContainer;

import java.awt.Graphics;
import java.awt.event.ActionEvent;

public class Centrifuge extends ExternalReagentButton {
    public Centrifuge(final SubstanceContainer abstractSubstance) {
        super(abstractSubstance, new com.pfeilda.ajb.equipment.Centrifuge());
    }

    @Override
    protected void paintComponentIcon(final Graphics g) {
        g.setColor(this.drawColor);

        final int xOffset = 10;
        final int yOffset = 3;

        g.drawLine(xOffset + 9, yOffset, xOffset + 21, yOffset);
        g.drawLine(xOffset + 21, yOffset, xOffset + 21, yOffset + 3);
        g.drawLine(xOffset + 21, yOffset + 3, xOffset + 9, yOffset + 3);
        g.drawLine(xOffset + 9, yOffset + 3, xOffset + 9, yOffset);
        g.drawLine(xOffset + 11, yOffset + 3, xOffset + 11, yOffset + 20);
        g.drawLine(xOffset + 19, yOffset + 3, xOffset + 19, yOffset + 20);
        g.drawArc(xOffset + 11, yOffset + 16, 8, 8, 0, -180);

        g.drawArc(xOffset, yOffset + 32, 30, 10, 0, -180);
        g.drawLine(xOffset, yOffset + 37, xOffset, yOffset + 42);
        g.drawLine(xOffset, yOffset + 37, xOffset + 5, yOffset + 37);

        g.drawArc(xOffset, yOffset + 28, 30, 10, 0, 180);
        g.drawLine(xOffset + 30, yOffset + 28, xOffset + 30, yOffset + 33);
        g.drawLine(xOffset + 30, yOffset + 33, xOffset + 25, yOffset + 33);
    }

    @Override
    protected void addActionListener() {
        final Centrifuge centrifuge = this;
        this.addActionListener((ActionEvent actionEvent) -> {
            centrifuge.toogleActive();
            centrifuge.repaint();
        });
    }
}
