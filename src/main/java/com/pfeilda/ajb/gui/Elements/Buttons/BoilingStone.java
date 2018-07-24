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
        //todo add offset
        g.drawLine(20, 10, 20, 30);
        g.drawLine(20, 30, 10, 40);
        g.drawLine(10, 40, 35, 40);
        g.drawLine(35, 40, 25, 30);
        g.drawLine(25, 30, 25, 10);
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
