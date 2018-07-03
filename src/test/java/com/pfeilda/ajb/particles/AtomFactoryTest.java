package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.Singleton;
import com.pfeilda.ajb.miscellaneous.TestInterface;
import org.junit.Assert;
import org.junit.Test;

public class AtomFactoryTest implements TestInterface {
    private final Atom referenceAtom;

    public AtomFactoryTest() {
        this.referenceAtom = new Atom("Hydrogen", "H", 1);
    }

    @Override
    public AtomFactory generateInstanceOfTestClass() {
        return AtomFactory.getInstance();
    }

    @Override
    @Test
    public void creation() {
        Assert.assertNotNull(this.generateInstanceOfTestClass());
    }

    @Test
    public void getSameInstance() {
        Assert.assertEquals(this.generateInstanceOfTestClass(), AtomFactory.getInstance());
    }

    @Test
    public final void inheritanceSuccess() {
        final AtomFactory atomFactory = this.generateInstanceOfTestClass();
        Assert.assertNotNull((Singleton) atomFactory);
    }

    @Test
    public void getAtomMethod() {
        final AtomFactory atomFactory = this.generateInstanceOfTestClass();
        Assert.assertEquals(
                this.referenceAtom,
                atomFactory.get(this.referenceAtom.getAtomicNumber())
        );
    }

    @Test
    public void generationOfUnkownAtomWithAtomicNumberLowerThan1() {
        final Atom atom = this.generateInstanceOfTestClass().get(0);
        Assert.assertNull(atom);
    }

    @Test
    public void generationOfUnkownAtomWithAtomicNumberHigherHigherNumberThan119() {
        final Atom atom = this.generateInstanceOfTestClass().get(120);
        Assert.assertNull(atom);
    }
}
