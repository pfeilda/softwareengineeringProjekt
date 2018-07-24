package com.pfeilda.ajb.miscellaneous;

import java.io.File;
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
    }

    @Override
    public final void persist() {
        final FileUtility fileUtility = FileUtility.getInstance();
        fileUtility.writeObjectToFile(
                this.highScores,
                this.highScoreFile
        );
    }
}
