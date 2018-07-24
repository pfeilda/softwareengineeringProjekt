package com.pfeilda.ajb.gui.Elements.Buttons;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.miscellaneous.HighScore;
import com.pfeilda.ajb.miscellaneous.HighScoreCalculator;
import com.pfeilda.ajb.miscellaneous.HighScoreUtility;

import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class EvaluateButton extends JButton {
    private final SubstanceContainer substanceContainer;

    public EvaluateButton(final SubstanceContainer substanceContainer) {
        this.substanceContainer = substanceContainer;

        this.setText("Auswerten");

        this.addActionListener(this::evaluateAction);
    }

    private void evaluateAction(final ActionEvent actionEvent) {
        final HighScore highScore = this.substanceContainer.evaluate(new HighScoreCalculator());

        HighScoreUtility highScoreUtility = HighScoreUtility.getInstance();

        highScoreUtility.add(highScore);
        highScoreUtility.persist();
    }
}
