package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.TestInterface;
import org.junit.Assert;
import org.junit.Test;

public class AtomTest implements TestInterface {
    private final int ordinal = 1;
    private final String elementSymbol = "H";
    private final String label = "Wasserstoff";

    @Override
    public final Atom generateInstanceOfTestClass() {
        return new Atom(this.label, this.elementSymbol, this.ordinal);
    }

    @Override
    @Test
    public final void creation() {
        final Atom atom = this.generateInstanceOfTestClass();
        Assert.assertNotNull(atom);
    }

    @Test
    public final void inheritanceSuccess() {
        final Atom atom = this.generateInstanceOfTestClass();
        Assert.assertNotNull((Element) atom);
    }

    @Test
    public final void experimentalProofSuccess() {
        final Atom atom = this.generateInstanceOfTestClass();
        Assert.assertTrue(atom.experimentalProof(true));
    }

    @Test
    public final void experimentalProofFails() {
        final Atom atom = this.generateInstanceOfTestClass();
        Assert.assertFalse(atom.experimentalProof(false));
    }

    @Test
    public final void getLabel() {
        final Atom atom = this.generateInstanceOfTestClass();
        Assert.assertEquals(atom.getLabel(), this.label);
    }

    @Test
    public final void getOrdinal() {
        final Atom atom = this.generateInstanceOfTestClass();
        Assert.assertEquals(atom.getOrdinal(), this.ordinal);
    }

    @Test
    public final void getElementSymbol() {
        final Atom atom = this.generateInstanceOfTestClass();
        Assert.assertEquals(atom.getElementSymbol(), this.elementSymbol);
    }

    @Test
    public final void isEquals() {
        Assert.assertEquals(new Atom(this.label, this.elementSymbol, this.ordinal), this.generateInstanceOfTestClass());
    }

    @Test
    public final void isNotEqualsWrongLabel() {
        Assert.assertNotEquals(new Atom(
                this.label + "wrong label",
                this.elementSymbol,
                this.ordinal
        ), this.generateInstanceOfTestClass());
    }

    @Test
    public final void isNotEqualsWrongSymbol() {
        Assert.assertNotEquals(new Atom(
                this.label,
                this.elementSymbol + "wrong symbol",
                this.ordinal
        ), this.generateInstanceOfTestClass());
    }

    @Test
    public final void isNotEqualsWrongOrdinal() {
        Assert.assertNotEquals(new Atom(
                this.label,
                this.elementSymbol,
                (this.ordinal + 1)
        ), this.generateInstanceOfTestClass());
    }

    @Test
    public final void isNotEqualsWrongLabelAndSymbol() {
        Assert.assertNotEquals(new Atom(
                this.label + "wrong label",
                this.elementSymbol + "and wrong symbol",
                this.ordinal
        ), this.generateInstanceOfTestClass());
    }

    @Test
    public final void isNotEqualsWrongSymbolAndOrdinal() {
        Assert.assertNotEquals(new Atom(
                this.label,
                this.elementSymbol + "and wrong symbol",
                (this.ordinal + 1)
        ), this.generateInstanceOfTestClass());
    }

    @Test
    public final void isNotEqualsWrongLabelAndSymbolAndOrdinal() {
        Assert.assertNotEquals(new Atom(
                this.label + "wrong label",
                this.elementSymbol + "and wrong symbol",
                (this.ordinal + 1)
        ), this.generateInstanceOfTestClass());
    }
}
