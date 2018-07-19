package com.pfeilda.ajb.gui.Elements.Buttons;

import com.pfeilda.ajb.equipment.AlterManager;
import com.pfeilda.ajb.gui.Elements.Partials.SpeedButtonGroup;

import javax.swing.JButton;

public abstract class SpeedButton extends JButton {
    public SpeedButton(final int speed, final String title, final SpeedButtonGroup speedButtonGroup) {
        super(title);
        this.addActionListener(actionEvent -> {
            final AlterManager alterManager = AlterManager.getInstance();
            alterManager.setSpeed(speed);
            speedButtonGroup.update(this);
        });
    }
}
