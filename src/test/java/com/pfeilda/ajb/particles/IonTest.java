package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.TestInterface;
import org.junit.Assert;
import org.junit.Test;

public class IonTest implements TestInterface {
    private final Atom[] atoms = new Atom[]{
            new Atom("Sauerstoff", "O", 8),
            new Atom("Schwefel", "S", 16)
    };
    private final String label = "Sulfat";
    private final int charge = 2;

    public Ion generateInstanceOfTestClass() {
        return new Ion(this.label, this.atoms, this.charge);
    }

    @Test
    public void creation() {
        final Ion ion = this.generateInstanceOfTestClass();
        Assert.assertNotNull(ion);
    }

    @Test
    public final void inheritanceSuccess() {
        final Ion ion = this.generateInstanceOfTestClass();
        Assert.assertNotNull((Element) ion);
    }

    @Test
    public final void experimentalProofSuccess() {
        final Ion ion = this.generateInstanceOfTestClass();
        Assert.assertTrue(ion.experimentalProof(true));
    }

    @Test
    public final void experimentalProofFails() {
        final Ion ion = this.generateInstanceOfTestClass();
        Assert.assertFalse(ion.experimentalProof(false));
    }

    @Test
    public final void getLabel() {
        final Ion ion = this.generateInstanceOfTestClass();
        Assert.assertEquals(ion.getLabel(), this.label);
    }
}
