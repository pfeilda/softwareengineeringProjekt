package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.TestInterface;
import org.junit.Assert;
import org.junit.Test;

public class MoleculeTest implements TestInterface {
    private final Ion[] ions = new Ion[]{
            new Ion(
                    "Wasserstoffion",
                    new Atom[]{new Atom("Wasserstoff", "H", 1)},
                    1
            ),
            new Ion(
                    "Wasserstoffion",
                    new Atom[]{new Atom("Wasserstoff", "H", 1)},
                    1),
            new Ion(
                    "Dioxid",
                    new Atom[]{new Atom("Sauerstoff", "O", 8)},
                    -2
            )
    };
    private final String label = "Wasser";

    public final Molecule generateInstanceOfTestClass() {
        return new Molecule(this.label, this.ions);
    }

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
}
