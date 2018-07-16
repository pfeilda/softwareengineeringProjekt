package com.pfeilda.ajb.miscellaneous;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.analysis.Reagent;
import com.pfeilda.ajb.gui.Elements.Labels.PHLabel;
import com.pfeilda.ajb.particles.AtomFactory;
import com.pfeilda.ajb.particles.Element;
import org.junit.Assert;
import org.junit.Test;

//extract Properties to baseclass
public class PHTest implements TestInterface {
    public final double defaultValue = 7;
    public final double minValue = 0;
    public final double maxValue = 14;
    public final double[] addValues = new double[]{0.5, -5., 4.5};
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

    @Test
    public final void getPH() {
        final PH ph = this.generateInstanceOfTestClass();
        Assert.assertEquals(this.defaultValue, ph.get(), this.delta);
    }

    @Test
    public final void addPH() {
        for (final double value :
                this.addValues) {
            final PH ph = this.generateInstanceOfTestClass();
            ph.add(new Pressure(value));
            Assert.assertEquals(value + this.defaultValue, ph.get(), this.delta);
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
        final PH differentPH = new PH(this.defaultValue + 10);
        Assert.assertNotEquals(differentPH, ph);
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
