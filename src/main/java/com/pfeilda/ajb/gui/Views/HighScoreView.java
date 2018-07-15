package com.pfeilda.ajb.gui.Views;

import com.pfeilda.ajb.gui.Elements.Buttons.ReturnToMenu;
import com.pfeilda.ajb.gui.ViewContainer;

import java.awt.Dimension;
import java.awt.HeadlessException;

public class HighScoreView extends View {
    public HighScoreView(final ViewContainer parent) throws HeadlessException {
        parent.setTitle("HighScores");
        parent.add(this);

        this.add(new ReturnToMenu(parent));

        parent.add(this);
        parent.revalidate();

        this.setSize(new Dimension(500, 500));
    }
}
