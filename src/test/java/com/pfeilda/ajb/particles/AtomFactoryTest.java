package com.pfeilda.ajb.particles;

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
    public void getAtomMethod() {
        final AtomFactory atomFactory = this.generateInstanceOfTestClass();
        Assert.assertEquals(
                this.referenceAtom,
                atomFactory.get(this.referenceAtom.getAtomicNumber())
        );
    }
}
