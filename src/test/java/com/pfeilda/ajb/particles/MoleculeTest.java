package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.TestInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MoleculeTest implements TestInterface {
    private final Ion[] ions = new Ion[]{
            new Ion(
                    "Hydrogen",
                    new Atom[]{new Atom("Wasserstoff", "H", 1)},
                    1
            ),
            new Ion(
                    "Hydrogen",
                    new Atom[]{new Atom("Wasserstoff", "H", 1)},
                    1),
            new Ion(
                    "Dioxid",
                    new Atom[]{new Atom("Sauerstoff", "O", 8)},
                    -2
            )
    };
    private final String label = "Wasser";

    @Override
    public final Molecule generateInstanceOfTestClass() {
        return new Molecule(this.label, this.ions);
    }

    @Override
    @Test
    public final void creation() {
        final Molecule molecule = this.generateInstanceOfTestClass();
        Assert.assertNotNull(molecule);
    }

    @Test
    public final void inheritanceSuccess() {
        final Molecule molecule = this.generateInstanceOfTestClass();
        Assert.assertNotNull((Element) molecule);
    }


    @Test
    public final void experimentalProofSuccess() {
        final Molecule molecule = this.generateInstanceOfTestClass();
        Assert.assertTrue(molecule.experimentalProof(true));
    }

    @Test
    public final void experimentalProofFails() {
        final Molecule molecule = this.generateInstanceOfTestClass();
        Assert.assertFalse(molecule.experimentalProof(false));
    }


    @Test
    public final void getIons() {
        Assert.assertArrayEquals(this.ions, this.generateInstanceOfTestClass().getIons());
    }

    @Test
    public final void isEquals() {
        Assert.assertEquals(this.generateInstanceOfTestClass(), this.generateInstanceOfTestClass());
    }

    @Test
    public final void isNotEquals() {
        final Molecule moleculeWrongLabel = new Molecule("Falsches label", this.ions);
        Assert.assertNotEquals(this.generateInstanceOfTestClass(),
                moleculeWrongLabel);

        final Ion[] ions = Arrays.copyOfRange(this.ions, 0, 1);
        final Molecule molecule1eWrongIons = new Molecule("Wasser", ions);
        Assert.assertNotEquals(molecule1eWrongIons, this.generateInstanceOfTestClass());
    }
}
