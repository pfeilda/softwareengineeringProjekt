package com.pfeilda.ajb.miscellaneous;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HighScoreUtility implements HighScoreUtilityInterface {
    private static final Object mutex = new Object();
    private volatile static HighScoreUtility instance;

    private final List<HighScore> highScores;
    private final File highScoreFile;

    private HighScoreUtility() {
        this.highScoreFile = new File(this.getClass().getResource("/HighScores.json").getFile());

        final FileUtility fileUtility = FileUtility.getInstance();

        final HighScore[] highScoreArray = fileUtility.readModelFromFile(this.highScoreFile, HighScore[].class);

        this.highScores = new ArrayList<>(Arrays.asList(highScoreArray));
        this.sort();
    }

    public static HighScoreUtility getInstance() {
        HighScoreUtility result = HighScoreUtility.instance;
        if (result == null) {
            synchronized (HighScoreUtility.mutex) {
                result = HighScoreUtility.instance;
                if (result == null) {
                    HighScoreUtility.instance = result = new HighScoreUtility();
                }
            }
        }
        return result;
    }

    @Override
    public final void add(final HighScore highScore) {
        this.highScores.add(highScore);
        this.sort();
    }

    @Override
    public final void persist() {
        final FileUtility fileUtility = FileUtility.getInstance();
        fileUtility.writeObjectToFile(
                this.highScores,
                this.highScoreFile
        );
    }

    @Override
    public void sort() {
        this.highScores.sort((first, last) -> {
            if (first.getScore() > last.getScore()) {
                return -1;
            }
            if (first.getScore() < last.getScore()) {
                return 1;
            }
            return first.getDate().compareTo(last.getDate());
        });
    }

    @Override
    public JPanel getPanel() {
        final JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(0, 3));

        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

        this.highScores.forEach(highScore -> {
            jPanel.add(new JLabel(highScore.getUsername()));
            jPanel.add(new JLabel(simpleDateFormat.format(highScore.getDate().getTime())));
            jPanel.add(new JLabel(highScore.getScore() + ""));
        });

        return jPanel;
    }
}
