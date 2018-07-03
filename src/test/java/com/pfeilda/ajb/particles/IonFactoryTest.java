package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.Singleton;
import com.pfeilda.ajb.miscellaneous.TestInterface;
import org.junit.Assert;
import org.junit.Test;

public class IonFactoryTest implements TestInterface {
    private final Atom referenceAtom;
    private final Ion referenceIon;

    public IonFactoryTest() {
        this.referenceAtom = new Atom("Hydrogen", "H", 1);
        this.referenceIon = new Ion("Hydrogen", new Atom[]{this.referenceAtom}, 1);
    }

    @Override
    public IonFactory generateInstanceOfTestClass() {
        return IonFactory.getInstance();
    }

    @Override
    @Test
    public void creation() {
        Assert.assertNotNull(this.generateInstanceOfTestClass());
    }

    @Test
    public void getSameInstance() {
        Assert.assertEquals(this.generateInstanceOfTestClass(), IonFactory.getInstance());
    }

    @Test
    public final void inheritanceSuccess() {
        final IonFactory ionFactory = this.generateInstanceOfTestClass();
        Assert.assertNotNull((Singleton) ionFactory);
    }

    @Test
    public void getIonMethod() {
        final IonFactory ionFactory = this.generateInstanceOfTestClass();
        Assert.assertEquals(
                this.referenceIon,
                ionFactory.get("Hydrogen")
        );
    }

    @Test
    public void generationOfUnkownIon() {
        final IonFactory ionFactory = this.generateInstanceOfTestClass();
        Assert.assertNull(
                ionFactory.get("123jfasd")
        );
    }
}
