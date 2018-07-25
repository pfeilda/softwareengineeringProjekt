package com.pfeilda.ajb.miscellaneous;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.analysis.Reagent;
import com.pfeilda.ajb.gui.Elements.Labels.TemperatureLabel;
import com.pfeilda.ajb.particles.AtomFactory;
import com.pfeilda.ajb.particles.Element;
import org.junit.Assert;
import org.junit.Test;

public class TemperatureTest extends PropertyTest {
    private final double[] addValues = new double[]{0.1, 0.2, 200, 300, 50};

    public TemperatureTest() {
        super(0.1, 0, 300);
    }

    @Override
    public final Temperature generateInstanceOfTestClass() {
        return this.generateInstanceOfTestClass(this.getDefaultValue());
    }

    @Override
    public Temperature generateInstanceOfTestClass(final Double value) {
        return new Temperature(value);
    }

    @Override
    @Test
    public final void creation() {
        Assert.assertNotNull(this.generateInstanceOfTestClass());
    }

    @Test
    public final void getTemperature() {
        final Temperature temperature = this.generateInstanceOfTestClass();
        Assert.assertEquals(this.getDefaultValue(), temperature.get(), this.delta);
    }

    @Test
    public final void addTemperature() {
        for (final double value :
                this.addValues) {
            final Temperature temperature = this.generateInstanceOfTestClass();
            temperature.add(new Temperature(value));
            Assert.assertEquals(value + this.getDefaultValue(), temperature.get(), this.delta);
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
        final Temperature differentTemperature = new Temperature(this.getDefaultValue() + 10);
        Assert.assertNotEquals(differentTemperature, temperature);
    }

    @Test
    public final void compareFailType() {
        final Volume volume = new Volume(this.getDefaultValue());
        Assert.assertNotEquals(this.generateInstanceOfTestClass(), volume);

        final Pressure pressure = new Pressure(this.getDefaultValue());
        Assert.assertNotEquals(this.generateInstanceOfTestClass(), pressure);
    }

    @Test
    public final void addTo() {
        final AtomFactory atomFactory = AtomFactory.getInstance();
        final AbstractSubstance abstractSubstance = new Reagent(new Element[]{atomFactory.get(7)});
        final Temperature referenceTemperature = new Temperature(abstractSubstance.getTemperature().get());

        final Temperature addTemperature = new Temperature(10);
        referenceTemperature.add(addTemperature);
        addTemperature.addTo(abstractSubstance);

        Assert.assertEquals(referenceTemperature, abstractSubstance.getTemperature());
    }

    @Test
    public final void generatePropertyLabel() {
        final Temperature temperature = this.generateInstanceOfTestClass();
        Assert.assertNotNull(temperature.getPropertyLabel());
        Assert.assertTrue(temperature.getPropertyLabel() instanceof TemperatureLabel);
    }

    @Override
    public void addUnderMinimum() {
        final Property property = this.generateInstanceOfTestClass(this.minimum);
        final Property addProperty = this.generateInstanceOfTestClass(-1 - this.minimum);
        property.add(addProperty);

        Assert.assertEquals(this.minimum, property.get(), 0.);
        Assert.assertTrue(property.isValid());
    }
}
