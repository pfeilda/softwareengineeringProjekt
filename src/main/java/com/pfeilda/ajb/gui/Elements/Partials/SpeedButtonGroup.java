package com.pfeilda.ajb.gui.Elements.Partials;

import com.pfeilda.ajb.gui.Elements.Buttons.ForwardButton;
import com.pfeilda.ajb.gui.Elements.Buttons.NormalButton;
import com.pfeilda.ajb.gui.Elements.Buttons.PauseButton;
import com.pfeilda.ajb.gui.Elements.Buttons.SpeedButton;

import java.util.ArrayList;
import java.util.List;

public class SpeedButtonGroup extends AbstractPartial {
    private final List<SpeedButton> speedButtons;

    public SpeedButtonGroup() {
        this.speedButtons = new ArrayList<>();
        this.speedButtons.add(new PauseButton(this));
        this.speedButtons.add(new NormalButton(this));
        this.speedButtons.add(new ForwardButton(this));
        this.addActionButtons();
    }

    @Override
    public void selectLayout() {
//        this.setLayout(new FlowLayout());
    }

    @Override
    public void addComponents() {
    }

    @Override
    public void addActionButtons() {
        final SpeedButtonGroup speedButtonGroup = this;
        this.speedButtons.forEach(speedButtonGroup::add);
    }

    public void update(final SpeedButton speedButtonPressed) {
        this.speedButtons.forEach((SpeedButton speedButton) -> {
            speedButton.setEnabled(true);
        });
        speedButtonPressed.setEnabled(false);
    }
}
