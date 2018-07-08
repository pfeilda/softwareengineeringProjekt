package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.miscellaneous.Pressure;
import com.pfeilda.ajb.miscellaneous.Temperature;
import com.pfeilda.ajb.miscellaneous.TestInterface;
import com.pfeilda.ajb.miscellaneous.Volume;
import com.pfeilda.ajb.particles.AtomFactory;
import com.pfeilda.ajb.particles.Element;
import com.pfeilda.ajb.particles.MoleculeFactory;
import org.junit.Assert;
import org.junit.Test;

public class ReagentTest implements TestInterface {
    private final Element[] elements;

    public ReagentTest() {
        final AtomFactory atomFactory = AtomFactory.getInstance();
        final MoleculeFactory moleculeFactory = MoleculeFactory.getInstance();

        this.elements = new Element[]{
                atomFactory.get(0),
                atomFactory.get(8),
                moleculeFactory.get("Water")
        };
    }

    @Override
    public Reagent generateInstanceOfTestClass() {
        return new Reagent(this.elements);
    }

    @Override
    @Test
    public void creation() {
        final Reagent reagent = this.generateInstanceOfTestClass();
        Assert.assertNotNull(reagent);
        Assert.assertEquals(new Volume(30), reagent.getVolume());
        Assert.assertEquals(new Pressure(0), reagent.getPressure());
        Assert.assertEquals(new Temperature(0), reagent.getTemperature());
        Assert.assertEquals(true, reagent.isValid());
    }
}
