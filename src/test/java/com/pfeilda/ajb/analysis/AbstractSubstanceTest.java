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
    protected final int defaultAddValue = 55;

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
    public void getPHInitial() {
        final AbstractSubstance abstractSubstance = this.generateInstanceOfTestClass();

        Assert.assertEquals(
                new PH(),
                abstractSubstance.getPh()
        );
    }

    @Test
    public void getPressureAfterAdd() {
        final AbstractSubstance abstractSubstance = this.generateInstanceOfTestClass();

        final Pressure addedPressure = new Pressure(this.defaultAddValue);

        final Pressure expectedPressure = new Pressure(
                addedPressure.get()
        );

        abstractSubstance.add(addedPressure);
        Assert.assertEquals(
                expectedPressure,
                abstractSubstance.getPressure()
        );
    }

    @Test
    public void getTemperatureAfterAdd() {
        final AbstractSubstance abstractSubstance = this.generateInstanceOfTestClass();

        final Temperature addedTemperature = new Temperature(this.defaultAddValue);

        final Temperature expectedTemperature = new Temperature(
                addedTemperature.get()
        );

        abstractSubstance.add(addedTemperature);
        Assert.assertEquals(
                expectedTemperature,
                abstractSubstance.getTemperature()
        );
    }

    @Test
    public void getVolumeAfterAdd() {
        final AbstractSubstance abstractSubstance = this.generateInstanceOfTestClass();

        final Volume addedVolume = new Volume(this.defaultAddValue);

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
    public void getPHAfterAdd() {
        final AbstractSubstance abstractSubstance = this.generateInstanceOfTestClass();

        final PH addedPH = new PH(2);

        final PH expectedPH = new PH(
                new PH().get() + addedPH.get()
        );

        abstractSubstance.add(addedPH);
        Assert.assertEquals(
                expectedPH,
                abstractSubstance.getPh()
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
    public void alterPH() {
        final AbstractSubstance abstractSubstance = this.generateInstanceOfTestClass();

        final PH alterPH = new PH(10);

        final PH referencePH = abstractSubstance.getPh();
        referencePH.add(alterPH);

        abstractSubstance.alter(new Property[]{
                alterPH
        });

        Assert.assertEquals(referencePH, abstractSubstance.getPh());
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
