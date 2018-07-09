package com.pfeilda.ajb.miscellaneous;

import org.junit.Assert;
import org.junit.Test;

public class VolumeTest implements TestInterface {
    private final double defaultValue = 1.0;
    private final double delta = 0.0;
    private final double[] addValues = new double[]{0.1, 0.2, 200, 300, 50};

    @Override
    public final Volume generateInstanceOfTestClass() {
        return new Volume(this.defaultValue);
    }

    @Override
    @Test
    public final void creation() {
        Assert.assertNotNull(this.generateInstanceOfTestClass());
    }

    @Test
    public final void getVolume() {
        final Volume volume = this.generateInstanceOfTestClass();
        Assert.assertEquals(this.defaultValue, volume.get(), this.delta);
    }

    @Test
    public final void addVolume() {
        for (final double value :
                this.addValues) {
            final Volume volume = this.generateInstanceOfTestClass();
            volume.add(new Volume(value));
            Assert.assertEquals(value + this.defaultValue, volume.get(), this.delta);
        }
    }

    @Test
    public final void compareSuccess() {
        final Volume volume = this.generateInstanceOfTestClass();
        Assert.assertEquals(volume, volume);
    }

    @Test
    public final void compareFailValue() {
        final Volume volume = this.generateInstanceOfTestClass();
        final Volume differentVolume = new Volume(this.defaultValue + 10);
        Assert.assertNotEquals(differentVolume, volume);
    }

    @Test
    public final void compareFailType() {
        final Temperature temperature = new Temperature(this.defaultValue);
        Assert.assertNotEquals(this.generateInstanceOfTestClass(), temperature);

        final Pressure pressure = new Pressure(this.defaultValue);
        Assert.assertNotEquals(this.generateInstanceOfTestClass(), pressure);
    }
}
