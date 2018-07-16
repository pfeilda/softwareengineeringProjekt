package com.pfeilda.ajb.miscellaneous;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.analysis.Reagent;
import com.pfeilda.ajb.gui.Elements.Labels.PressureLabel;
import com.pfeilda.ajb.particles.AtomFactory;
import com.pfeilda.ajb.particles.Element;
import org.junit.Assert;
import org.junit.Test;

public class PressureTest {
    private final double defaultValue = 1.0;
    private final double delta = 0.0;
    private final double[] addValues = new double[]{0.1, 0.2, 200, 300, 50};

    public final Pressure generateInstanceOfTestClass() {
        return new Pressure(this.defaultValue);
    }

    @Test
    public final void creation() {
        Assert.assertNotNull(this.generateInstanceOfTestClass());
    }

    @Test
    public final void getPressure() {
        final Pressure pressure = this.generateInstanceOfTestClass();
        Assert.assertEquals(this.defaultValue, pressure.get(), this.delta);
    }

    @Test
    public final void addPressure() {
        for (final double value :
                this.addValues) {
            final Pressure pressure = this.generateInstanceOfTestClass();
            pressure.add(new Pressure(value));
            Assert.assertEquals(value + this.defaultValue, pressure.get(), this.delta);
        }
    }

    @Test
    public final void compareSuccess() {
        final Pressure pressure = this.generateInstanceOfTestClass();
        Assert.assertEquals(pressure, pressure);
    }

    @Test
    public final void compareFailValue() {
        final Pressure pressure = this.generateInstanceOfTestClass();
        final Pressure differentPressure = new Pressure(this.defaultValue + 10);
        Assert.assertNotEquals(differentPressure, pressure);
    }

    @Test
    public final void compareFailType() {
        final Temperature temperature = new Temperature(this.defaultValue);
        Assert.assertNotEquals(this.generateInstanceOfTestClass(), temperature);

        final Volume volume = new Volume(this.defaultValue);
        Assert.assertNotEquals(this.generateInstanceOfTestClass(), volume);
    }

    @Test
    public final void addTo() {
        final AtomFactory atomFactory = AtomFactory.getInstance();
        final AbstractSubstance abstractSubstance = new Reagent(new Element[]{atomFactory.get(7)});
        final Pressure referencePressure = new Pressure(abstractSubstance.getPressure().get());

        final Pressure addPressure = new Pressure(10);
        referencePressure.add(addPressure);
        addPressure.addTo(abstractSubstance);

        Assert.assertEquals(referencePressure, abstractSubstance.getPressure());
    }

    @Test
    public final void generatePropertyLabel() {
        final Pressure pressure = this.generateInstanceOfTestClass();
        Assert.assertNotNull(pressure.getPropertyLabel());
        Assert.assertTrue(pressure.getPropertyLabel() instanceof PressureLabel);
    }
}
