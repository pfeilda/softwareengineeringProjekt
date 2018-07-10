package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.miscellaneous.*;
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
    public void getTemperatureInitial() {
        final AbstractSubstance abstractSubstance = this.generateInstanceOfTestClass();

        Assert.assertEquals(
                new Temperature(0),
                abstractSubstance.getTemperature()
        );
    }

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

    @Test
    public void alterVolume() {
        final AbstractSubstance abstractSubstance = this.generateInstanceOfTestClass();

        final Volume alterVolume = new Volume(10);

        final Volume referenceVolume = abstractSubstance.getVolume();
        referenceVolume.add(alterVolume);

        abstractSubstance.alter(new Property[]{
                alterVolume
        });

        Assert.assertEquals(referenceVolume, abstractSubstance.getVolume());
    }


    @Test
    public void alterTemperature() {
        final AbstractSubstance abstractSubstance = this.generateInstanceOfTestClass();

        final Temperature alterTemperature = new Temperature(10);

        final Temperature referenceTemperature = abstractSubstance.getTemperature();
        referenceTemperature.add(alterTemperature);

        abstractSubstance.alter(new Property[]{
                alterTemperature
        });

        Assert.assertEquals(referenceTemperature, abstractSubstance.getTemperature());
    }

    @Test
    public void alterPressure() {
        final AbstractSubstance abstractSubstance = this.generateInstanceOfTestClass();

        final Pressure alterPressure = new Pressure(10);

        final Pressure referencePressure = abstractSubstance.getPressure();
        referencePressure.add(alterPressure);

        abstractSubstance.alter(new Property[]{
                alterPressure
        });

        Assert.assertEquals(referencePressure, abstractSubstance.getPressure());
    }


    //todo maybe implement other combinations
    @Test
    public void alterPressureAndTemperature() {
        final AbstractSubstance abstractSubstance = this.generateInstanceOfTestClass();

        final Temperature alterTemperature = new Temperature(10);

        final Temperature referenceTemperature = abstractSubstance.getTemperature();
        referenceTemperature.add(alterTemperature);

        final Pressure alterPressure = new Pressure(10);

        final Pressure referencePressure = abstractSubstance.getPressure();
        referencePressure.add(alterPressure);

        abstractSubstance.alter(new Property[]{
                alterPressure,
                alterTemperature
        });

        Assert.assertEquals(referencePressure, abstractSubstance.getPressure());
        Assert.assertEquals(referenceTemperature, abstractSubstance.getTemperature());
    }
}
