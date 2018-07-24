package com.pfeilda.ajb.miscellaneous;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.GregorianCalendar;

public class HighScore {
    private final int score;
    private final GregorianCalendar date;
    private final String username;

    public HighScore(
            @JsonProperty("score") final int score,
            @JsonProperty("date") final GregorianCalendar date,
            @JsonProperty("username") final String username
    ) {
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
