package com.pfeilda.ajb;

import org.junit.Assert;
import org.junit.Test;

public class AtomTest {
    @Test
    public final void creation(){
        Atom atom = new Atom();
        Assert.assertTrue(atom instanceof Atom);
    }
}
