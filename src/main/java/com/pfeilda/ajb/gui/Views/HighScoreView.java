package com.pfeilda.ajb.gui.Views;

import com.pfeilda.ajb.gui.Elements.Buttons.ReturnToMenu;
import com.pfeilda.ajb.gui.ViewContainerAbstract;
import com.pfeilda.ajb.miscellaneous.HighScoreUtility;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class HighScoreView extends View {
    public HighScoreView(final ViewContainerAbstract parent) {
        super(parent, "Highscores");
    }

    @Override
    public void selectLayout() {
        this.setLayout(new BorderLayout());
    }

    @Override
    public void addComponents() {
        this.add(this.getHighScoreScrollPane());

        this.add(new ReturnToMenu(this.parent), BorderLayout.PAGE_END);
    }

    @Override
    public void addActionButtons() {

    }

    private JScrollPane getHighScoreScrollPane() {
        final HighScoreUtility highScoreUtility = HighScoreUtility.getInstance();

        final JScrollPane jScrollPane = new JScrollPane(highScoreUtility.getPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        jScrollPane.setEnabled(true);
        jScrollPane.setPreferredSize(new Dimension(500, 500));

        return jScrollPane;
    }
}
