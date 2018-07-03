package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.Singleton;
import com.pfeilda.ajb.miscellaneous.TestInterface;
import org.junit.Assert;
import org.junit.Test;

public class MoleculeFactoryTest implements TestInterface {
    private final Atom[] referenceAtom = new Atom[2];
    private final Ion[] referenceIon = new Ion[2];
    private final Molecule referenceMolecule;

    public MoleculeFactoryTest() {
        this.referenceAtom[0] = new Atom("Hydrogen", "H", 1);
        this.referenceAtom[1] = new Atom("Oxygen", "O", 8);

        this.referenceIon[0] = new Ion("Hydrogen", new Atom[]{this.referenceAtom[0]}, 1);
        this.referenceIon[1] = new Ion("Oxid", new Atom[]{this.referenceAtom[1]}, -2);

        this.referenceMolecule = new Molecule("Water", this.referenceIon);
    }

    @Override
    public MoleculeFactory generateInstanceOfTestClass() {
        return MoleculeFactory.getInstance();
    }

    @Override
    @Test
    public void creation() {
        Assert.assertNotNull(this.generateInstanceOfTestClass());
    }

    @Test
    public void getSameInstance() {
        Assert.assertEquals(this.generateInstanceOfTestClass(), MoleculeFactory.getInstance());
    }

    @Test
    public final void inheritanceSuccess() {
        final MoleculeFactory moleculeFactory = this.generateInstanceOfTestClass();
        Assert.assertNotNull((Singleton) moleculeFactory);
    }

    @Test
    public final void getMoleculeMethod() {
        final MoleculeFactory moleculeFactory = MoleculeFactory.getInstance();
        Assert.assertEquals(
                this.referenceMolecule,
                moleculeFactory.get(this.referenceMolecule.getLabel())
        );
    }

    @Test
    public void generationOfUnkownIon() {
        final MoleculeFactory moleculeFactory = this.generateInstanceOfTestClass();
        Assert.assertNull(
                moleculeFactory.get("123jfasd")
        );
    }
}
