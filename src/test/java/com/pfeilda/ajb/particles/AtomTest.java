package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.Singleton;
import com.pfeilda.ajb.miscellaneous.TestInterface;
import org.junit.Assert;
import org.junit.Test;

public class AtomTest implements TestInterface {
    private final int ordinal = 1;
    private final String elementSymbol = "H";
    private final String label = "Wasserstoff";

    public final Atom getAtom() {
        return new Atom(this.label, this.elementSymbol, this.ordinal);
    }

    @Override
    @Test
    public final void creation() {
        final Atom atom = this.getAtom();
        Assert.assertNotNull(atom);
    }

    @Test
    public final void inheritanceSuccess() {
        final Atom atom = this.getAtom();
        Assert.assertNotNull((Element) atom);
    }

    @Test
    public final void experimentalProofSuccess() {
        final Atom atom = this.getAtom();
        Assert.assertTrue(atom.experimentalProof());
    }

    @Test
    public final void experimentalProofFails() {
        final Atom atom = this.getAtom();
        Assert.assertFalse(atom.experimentalProof());
    }

    @Test
    public final void getLabel() {
        final Atom atom = this.getAtom();
        Assert.assertEquals(atom.getLabel(), this.label);
    }

    @Test
    public final void getOrdinal() {
        final Atom atom = this.getAtom();
        Assert.assertEquals(atom.getOrdinal(), this.ordinal);
    }

    @Test
    public final void getElementSymbol() {
        final Atom atom = this.getAtom();
        Assert.assertEquals(atom.getElementSymbol(), this.elementSymbol);
    }
}
