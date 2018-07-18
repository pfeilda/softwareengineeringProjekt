package com.pfeilda.ajb.miscellaneous;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.analysis.Reagent;
import com.pfeilda.ajb.gui.Elements.Labels.PHLabel;
import com.pfeilda.ajb.particles.AtomFactory;
import com.pfeilda.ajb.particles.Element;
import org.junit.Assert;
import org.junit.Test;

//extract Properties to baseclass
public class PHTest extends PropertyTest {
    public final double[] addValues = new double[]{0.5, -5., 4.5};

    public PHTest() {
        super(7, 0, 14);
    }

    @Override
    public PH generateInstanceOfTestClass() {
        return new PH();
    }

    @Override
    public PH generateInstanceOfTestClass(final Double value) {
        return new PH(value);
    }

    @Override
    @Test
    public void creation() {
        final PH ph = this.generateInstanceOfTestClass();
        Assert.assertNotNull(ph);
        Assert.assertEquals(this.getDefaultValue(), ph.get(), this.delta);
    }

    @Test
    public final void getPH() {
        final PH ph = this.generateInstanceOfTestClass();
        Assert.assertEquals(this.getDefaultValue(), ph.get(), this.delta);
    }

    @Test
    public final void addPH() {
        for (final double value :
                this.addValues) {
            final PH ph = this.generateInstanceOfTestClass();
            ph.add(new Pressure(value));
            Assert.assertEquals(value + this.getDefaultValue(), ph.get(), this.delta);
        }
    }

    @Test
    public final void compareSuccess() {
        final PH ph = this.generateInstanceOfTestClass();
        Assert.assertEquals(ph, ph);
    }

    @Test
    public final void compareFailValue() {
        final PH ph = this.generateInstanceOfTestClass();
        final PH differentPH = new PH(this.getDefaultValue() + 10);
        Assert.assertNotEquals(differentPH, ph);
    }

    @Test
    public final void compareFailType() {
        final Temperature temperature = new Temperature(this.getDefaultValue());
        Assert.assertNotEquals(this.generateInstanceOfTestClass(), temperature);

        final Volume volume = new Volume(this.getDefaultValue());
        Assert.assertNotEquals(this.generateInstanceOfTestClass(), volume);
    }

    @Test
    public final void addTo() {
        final AtomFactory atomFactory = AtomFactory.getInstance();
        final AbstractSubstance abstractSubstance = new Reagent(new Element[]{atomFactory.get(7)});
        final PH referencePH = new PH(abstractSubstance.getPh().get());

        final PH addPH = new PH(10);
        referencePH.add(addPH);
        addPH.addTo(abstractSubstance);

        Assert.assertEquals(referencePH, abstractSubstance.getPh());
    }

    @Test
    public final void generatePropertyLabel() {
        final PH ph = this.generateInstanceOfTestClass();
        Assert.assertNotNull(ph.getPropertyLabel());
        Assert.assertTrue(ph.getPropertyLabel() instanceof PHLabel);
    }
}
