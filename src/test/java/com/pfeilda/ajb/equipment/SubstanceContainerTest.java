package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.analysis.Reagent;
import com.pfeilda.ajb.miscellaneous.TestInterface;
import com.pfeilda.ajb.miscellaneous.Volume;
import com.pfeilda.ajb.particles.AtomFactory;
import com.pfeilda.ajb.particles.Element;
import com.pfeilda.ajb.particles.IonFactory;
import com.pfeilda.ajb.particles.MoleculeFactory;
import org.junit.Assert;
import org.junit.Test;

public abstract class SubstanceContainerTest implements TestInterface {
    protected final Element[] elements;
    protected final Reagent reagent;
    protected Volume maxVolume;

    public SubstanceContainerTest() {
        final AtomFactory atomFactory = AtomFactory.getInstance();
        final MoleculeFactory moleculeFactory = MoleculeFactory.getInstance();
        final IonFactory ionFactory = IonFactory.getInstance();

        this.elements = new Element[]{
                atomFactory.get(1),
                atomFactory.get(2),
                moleculeFactory.get("Water"),
                ionFactory.get("Oxid")
        };

        this.reagent = new Reagent(this.elements);
    }

    public abstract SubstanceContainer generateInstanceOfTestClass(final AbstractSubstance abstractSubstance);

    @Override
    public abstract SubstanceContainer generateInstanceOfTestClass();

    @Override
    @Test
    public void creation() {
        final SubstanceContainer substanceContainer = this.generateInstanceOfTestClass();
        Assert.assertNotNull(substanceContainer);
    }

    @Test
    public void createWithElementsList() {
        final SubstanceContainer substanceContainer = this.generateInstanceOfTestClass(this.reagent);
        Assert.assertNotNull(substanceContainer);
    }

    @Test
    public void clear() {
        final SubstanceContainer substanceContainer = this.generateInstanceOfTestClass(this.reagent);
        substanceContainer.clear();
        Assert.assertTrue(substanceContainer.isCleared());
    }

    @Test
    public void isActionAllowedSuccess() {
        final SubstanceContainer substanceContainer = this.generateInstanceOfTestClass(this.reagent);
        Assert.assertTrue(substanceContainer.isAllowed());
    }

    @Test
    public void isActionAllowedFailure() {
        final Volume failureVolume = new Volume(20);
        failureVolume.add(this.maxVolume);

        final Reagent failureReagent = new Reagent(this.elements);
        failureReagent.add(failureVolume);

        final SubstanceContainer substanceContainer = this.generateInstanceOfTestClass(failureReagent);
        Assert.assertFalse(substanceContainer.isAllowed());
    }

    @Test
    public void getMaxVolumeSuccess() {
        final SubstanceContainer substanceContainer = this.generateInstanceOfTestClass();
        Assert.assertEquals(this.maxVolume, substanceContainer.getMaxVolume());
    }
}
