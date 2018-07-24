package com.pfeilda.ajb.miscellaneous;

import com.pfeilda.ajb.analysis.BasicAssay;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.GregorianCalendar;

public class HighScoreCalculator implements HighScoreInterface {
    @Override
    public HighScore calculateHighScore(final BasicAssay.AssayAccessor analysis) {
        final int amountFoundWrong = analysis.foundNotContainingElements() + analysis.notFoundContainingElements();

        final int score = this.calculateScore(amountFoundWrong, analysis.getAssayDuration());

        final String username = JOptionPane.showInputDialog(
                new JFrame(),
                "Bitte gebe deinen Namen fuer die HighScore Liste ein",
                "Nutzername",
                JOptionPane.PLAIN_MESSAGE
        );

        return new HighScore(score, (GregorianCalendar) GregorianCalendar.getInstance(), username);
    }

    private int calculateScore(final int amoundFoundWrong, final long millis) {
        int score = 1000 - (amoundFoundWrong * 100);
        final int timeFactor = (int) (millis / (1000 * 60 * 60));
        if (timeFactor != 0) {
            score += 1000 / timeFactor;
        }

        return score;
    }
}
