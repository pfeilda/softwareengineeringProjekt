package com.pfeilda.ajb.gui.Elements.Buttons;

import com.pfeilda.ajb.equipment.AlterManager;
import com.pfeilda.ajb.equipment.ExternalReagent;
import com.pfeilda.ajb.equipment.SubstanceContainer;

import javax.swing.JButton;
import java.awt.*;

public abstract class ExternalReagentButton extends JButton {
    private Color color1;
    private Color color2;
    protected Color drawColor = Color.WHITE;
    private final AlterManager alterManager;
    protected boolean isActive = true;
    protected SubstanceContainer abstractSubstance;
    protected ExternalReagent externalReagent;

    protected ExternalReagentButton(final SubstanceContainer substanceContainer, final ExternalReagent externalReagent) {
        this.abstractSubstance = substanceContainer;

        this.externalReagent = externalReagent;
        this.externalReagent.add(this.abstractSubstance);

        this.alterManager = AlterManager.getInstance();

        this.setOpaque(false);
        this.setBorderPainted(false);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setLayout();

        this.toogleActive();

        this.addActionListener();
    }

    protected void toogleActive() {
        if (this.isActive) {
            this.isActive = false;
            this.color1 = new Color(0xF62B2B);
            this.color2 = new Color(0xD20202);
            this.alterManager.deleteObserver(this.externalReagent);
        } else {
            this.isActive = true;
            this.color1 = new Color(0x4ba614);
            this.color2 = new Color(0x008c00);
            this.alterManager.addObserver(this.externalReagent);
        }
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        final Graphics2D g2 = (Graphics2D) g.create();
        final GradientPaint gradientPaint = this.getGradientPaint();
        g2.setPaint(gradientPaint);
        g2.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 10, 10);
        g2.dispose();
    }

    private GradientPaint getGradientPaint() {
        return new GradientPaint(
                new Point(0, 0),
                this.color1,
                new Point(0, this.getHeight()),
                this.color2
        );
    }

    private void setLayout() {
        final Dimension dimension = new Dimension(50, 50);
        this.setSize(dimension);
        this.setMinimumSize(dimension);
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
    }

    @Override
    public void paint(final Graphics g) {
        super.paint(g);

        this.paintComponentIcon(g);
    }

    protected abstract void addActionListener();

    protected abstract void paintComponentIcon(Graphics graphics);
}
