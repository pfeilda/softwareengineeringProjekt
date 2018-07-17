package com.pfeilda.ajb.gui.Elements.Buttons;

import com.pfeilda.ajb.analysis.Assay;
import com.pfeilda.ajb.equipment.SubstanceContainer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

public class BunsenBurner extends ExternalReagentButton {
    public BunsenBurner(final SubstanceContainer substanceContainer) {
        super(substanceContainer, new com.pfeilda.ajb.equipment.BunsenBurner());
    }

    @Override
    protected void paintComponentIcon(final Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(20, 20, 20, 40);
        g.drawLine(20, 40, 10, 50);
        g.drawLine(10, 50, 35, 50);
        g.drawLine(35, 50, 25, 40);
        g.drawLine(25, 40, 25, 20);
    }

    @Override
    protected void addActionListener() {
        final BunsenBurner bunsenBurner = this;
        this.addActionListener((ActionEvent actionEvent) -> {
            bunsenBurner.toogleActive();
            bunsenBurner.repaint();
        });
    }
}
