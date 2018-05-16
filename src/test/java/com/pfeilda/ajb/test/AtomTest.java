package com.pfeilda.ajb.test;

import org.junit.Assert;
import org.junit.Test;

public class AtomTest implements TestInterface {
    @Test
    public final void creation(){
        Atom atom = new Atom();
        Assert.assertTrue(atom instanceof Atom);
    }
}
