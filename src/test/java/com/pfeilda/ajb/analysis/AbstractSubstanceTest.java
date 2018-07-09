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

public abstract class AbstractSubstanceTest implements TestInterface {
    protected final Element[] elements;
    protected final int volumePerElement = 10;

    public AbstractSubstanceTest() {
        final AtomFactory atomFactory = AtomFactory.getInstance();
        final MoleculeFactory moleculeFactory = MoleculeFactory.getInstance();

        this.elements = new Element[]{
                atomFactory.get(0),
                atomFactory.get(8),
                moleculeFactory.get("Water")
        };
    }

    @Override
    public abstract AbstractSubstance generateInstanceOfTestClass();

    @Test
    public void getPressureInitial() {
        final AbstractSubstance abstractSubstance = this.generateInstanceOfTestClass();

        Assert.assertEquals(
                new Pressure(0),
                abstractSubstance.getPressure()
        );
    }

    @Test
    public abstract void getPressureAfterAlter();

    @Test
    public void getTemperatureInitial() {
        final AbstractSubstance abstractSubstance = this.generateInstanceOfTestClass();

        Assert.assertEquals(
                new Temperature(0),
                abstractSubstance.getTemperature()
        );
    }

    @Test
    public abstract void getTemperatureAfterAlter();

    @Test
    public void getVolumeInitial() {
        final AbstractSubstance abstractSubstance = this.generateInstanceOfTestClass();

        Assert.assertEquals(
                new Volume(this.elements.length * this.volumePerElement),
                abstractSubstance.getVolume()
        );
    }

    @Test
    public void getVolumeAfterAdd() {
        final AbstractSubstance abstractSubstance = this.generateInstanceOfTestClass();

        final Volume addedVolume = new Volume(20);

        final Volume expectedVolume = new Volume(
                (this.elements.length * this.volumePerElement) + addedVolume.get()
        );

        abstractSubstance.add(addedVolume);
        Assert.assertEquals(
                expectedVolume,
                abstractSubstance.getVolume()
        );
    }

    @Test
    public void destroySuccess() {
        final AbstractSubstance abstractSubstance = this.generateInstanceOfTestClass();

        Assert.assertTrue(abstractSubstance.isValid());
        abstractSubstance.destroy();
        Assert.assertFalse(abstractSubstance.isValid());
    }

    @Test
    public void isValidSuccess() {
        final AbstractSubstance abstractSubstance = this.generateInstanceOfTestClass();

        Assert.assertTrue(abstractSubstance.isValid());
    }
}
