package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.TestInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class IonTest implements TestInterface {
    private final Atom[] atoms = new Atom[]{
            new Atom("Sauerstoff", "O", 6),
            new Atom("Schwefel", "S", 4)
    };
    private final String label = "Sulfat";
    private final int charge = 2;

    @Override
    public Ion genereateInstanceOfTestClass() {
        return new Ion(this.label, this.atoms, this.charge);
    }

    @Override
    @Test
    public void creation() {
        final Ion ion = this.genereateInstanceOfTestClass();
        Assert.assertNotNull(ion);
    }

    @Test
    public final void inheritanceSuccess() {
        final Ion ion = this.genereateInstanceOfTestClass();
        Assert.assertNotNull((Element) ion);
    }

    @Test
    public final void experimentalProofSuccess() {
        final Ion ion = this.genereateInstanceOfTestClass();
        Assert.assertTrue(ion.experimentalProof(true));
    }

    @Test
    public final void experimentalProofFails() {
        final Ion ion = this.genereateInstanceOfTestClass();
        Assert.assertFalse(ion.experimentalProof(false));
    }

    @Test
    public final void getLabel() {
        final Ion ion = this.genereateInstanceOfTestClass();
        Assert.assertEquals(ion.getLabel(), this.label);
    }
}
