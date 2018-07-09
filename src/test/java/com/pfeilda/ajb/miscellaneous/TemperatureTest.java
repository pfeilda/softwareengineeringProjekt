package com.pfeilda.ajb.miscellaneous;

import org.junit.Assert;
import org.junit.Test;

public class TemperatureTest implements TestInterface {
    private final double defaultValue = 1.0;
    private final double delta = 0.0;
    private final double[] addValues = new double[]{0.1, 0.2, 200, 300, 50};

    @Override
    public final Temperature generateInstanceOfTestClass() {
        return new Temperature(this.defaultValue);
    }

    @Override
    @Test
    public final void creation() {
        Assert.assertNotNull(this.generateInstanceOfTestClass());
    }

    @Test
    public final void getTemperature() {
        final Temperature temperature = this.generateInstanceOfTestClass();
        Assert.assertEquals(this.defaultValue, temperature.get(), this.delta);
    }

    @Test
    public final void addTemperature() {
        for (final double value :
                this.addValues) {
            final Temperature temperature = this.generateInstanceOfTestClass();
            temperature.add(new Temperature(value));
            Assert.assertEquals(value + this.defaultValue, temperature.get(), this.delta);
        }
    }

    @Test
    public final void compareSuccess() {
        final Temperature temperature = this.generateInstanceOfTestClass();
        Assert.assertEquals(temperature, temperature);
    }

    @Test
    public final void compareFailValue() {
        final Temperature temperature = this.generateInstanceOfTestClass();
        final Temperature differentTemperature = new Temperature(this.defaultValue + 10);
        Assert.assertNotEquals(differentTemperature, temperature);
    }

    @Test
    public final void compareFailType() {
        final Volume volume = new Volume(this.defaultValue);
        Assert.assertNotEquals(this.generateInstanceOfTestClass(), volume);

        final Pressure pressure = new Pressure(this.defaultValue);
        Assert.assertNotEquals(this.generateInstanceOfTestClass(), pressure);
    }
}
