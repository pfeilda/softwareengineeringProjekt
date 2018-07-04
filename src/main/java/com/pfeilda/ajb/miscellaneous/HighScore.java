package com.pfeilda.ajb.miscellaneous;

import java.util.GregorianCalendar;

public class HighScore {
    private final int score;
    private final GregorianCalendar date;
    private final String username;

    public HighScore(final int score, final GregorianCalendar date, final String username) {
        this.score = score;
        this.date = date;
        this.username = username;
    }

    public int getScore() {
        return this.score;
    }

    public GregorianCalendar getDate() {
        return this.date;
    }

    public String getUsername() {
        return this.username;
    }
}
