package com.pfeilda.ajb.miscellaneous;

import org.junit.Assert;
import org.junit.Test;

import java.util.GregorianCalendar;

public class HighScoreTest implements TestInterface {
    private final int score = 360;
    private final GregorianCalendar date = new GregorianCalendar(2016, 1, 1, 10, 15);
    private final String username = "Testuser";

    @Override
    public HighScore generateInstanceOfTestClass() {
        return new HighScore(this.score, this.date, this.username);
    }

    @Override
    @Test
    public void creation() {
        Assert.assertNotNull(this.generateInstanceOfTestClass());
    }

    @Test
    public void getterForScoreSameValue() {
        Assert.assertEquals(this.score, this.generateInstanceOfTestClass().getScore());
    }

    @Test
    public void getterForDateSameValue() {
        Assert.assertEquals(this.date, this.generateInstanceOfTestClass().getDate());
    }

    @Test
    public void getterForUsernameSameValue() {
        Assert.assertEquals(this.username, this.generateInstanceOfTestClass().getUsername());
    }

    @Test
    public void getterForScoreDifferentValue() {
        Assert.assertNotEquals(0, this.generateInstanceOfTestClass().getScore());
    }

    @Test
    public void getterForDateDifferentValue() {
        Assert.assertNotEquals(new GregorianCalendar(), this.generateInstanceOfTestClass().getDate());
    }

    @Test
    public void getterForUsernameDifferentValue() {
        Assert.assertNotEquals("wrong name", this.generateInstanceOfTestClass().getUsername());
    }
}
