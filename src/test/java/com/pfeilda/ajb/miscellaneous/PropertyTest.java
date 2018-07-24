package com.pfeilda.ajb.miscellaneous;

import org.junit.Assert;
import org.junit.Test;

//todo refactor subclasses
public abstract class PropertyTest implements TestInterface {
    private final double defaultValue;
    protected final double minimum;
    protected final double maximum;
    protected final double delta = 0;

    public PropertyTest(final double defaultValue, final double minimum, final double maximum) {
        this.defaultValue = defaultValue;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public double getDefaultValue() {
        return this.defaultValue;
    }

    @Override
    public abstract Property generateInstanceOfTestClass();


    public abstract Property generateInstanceOfTestClass(Double value);

    @Test
    public void correctMinimumCreation() {
        final Property property = this.generateInstanceOfTestClass(this.minimum);
        Assert.assertTrue(property.isValid());
    }

    @Test
    public void failureMinimumCreation() {
        final Property property = this.generateInstanceOfTestClass((this.minimum - Double.MIN_VALUE));
        Assert.assertFalse(property.isValid());
    }

    @Test
    public void correctMaximumCreation() {
        final Property property = this.generateInstanceOfTestClass(this.maximum);
        Assert.assertTrue(property.isValid());
    }

    @Test
    public void failureMaximumCreation() {
        final Property property = this.generateInstanceOfTestClass((this.maximum + Double.MAX_VALUE));
        Assert.assertFalse(property.isValid());
    }

    @Test
    public void failureAddOverMaximum() {
        final Property property = this.generateInstanceOfTestClass(this.maximum);
        final Property addProperty = this.generateInstanceOfTestClass(1 + this.minimum);
        property.add(addProperty);

        Assert.assertFalse(property.isValid());
    }

    @Test
    public void addUnderMinimum() {
        final Property property = this.generateInstanceOfTestClass(this.minimum);
        final Property addProperty = this.generateInstanceOfTestClass(-1 - this.minimum);
        property.add(addProperty);

        Assert.assertFalse(property.isValid());
    }
}
