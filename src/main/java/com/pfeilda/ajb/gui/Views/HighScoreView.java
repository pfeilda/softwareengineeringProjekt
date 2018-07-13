package com.pfeilda.ajb.gui.Views;

import com.pfeilda.ajb.gui.Elements.Buttons.ReturnToMenu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.HeadlessException;

public class HighScoreView extends JPanel {
    public HighScoreView(final JFrame parent) throws HeadlessException {
        parent.setTitle("HighScores");
        parent.add(this);

        this.add(new ReturnToMenu(parent));

        parent.add(this);
        parent.revalidate();

        this.setSize(new Dimension(500, 500));
    }
}
