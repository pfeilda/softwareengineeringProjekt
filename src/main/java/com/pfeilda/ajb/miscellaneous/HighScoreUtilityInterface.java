package com.pfeilda.ajb.miscellaneous;

import javax.swing.JPanel;

public interface HighScoreUtilityInterface {
    void add(final HighScore highScore);

    void persist();

    void sort();

    JPanel getPanel();
}
