package com.pfeilda.ajb.miscellaneous;

import org.junit.Assert;
import org.junit.Test;

public class PHTest implements TestInterface {
    public final double defaultValue = 7;
    public final double minValue = 0;
    public final double maxValue = 14;
    public final double delta = 0;

    @Override
    public PH generateInstanceOfTestClass() {
        return new PH();
    }

    @Override
    @Test
    public void creation() {
        final PH ph = this.generateInstanceOfTestClass();
        Assert.assertNotNull(ph);
        Assert.assertEquals(this.defaultValue, ph.get(), this.delta);
    }
}
