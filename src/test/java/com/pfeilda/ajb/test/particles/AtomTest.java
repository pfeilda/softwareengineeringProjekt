package com.pfeilda.ajb.test.particles;

import com.pfeilda.ajb.particles.Atom;
import com.pfeilda.ajb.test.TestInterface;
import com.pfeilda.ajb.particles.Element;
import org.junit.Assert;
import org.junit.Test;

public class AtomTest implements TestInterface {
    @Override
    public final void creation() {
        Atom atom = new Atom("Wasserstoff", "H", 1);
        Assert.assertNotNull(atom);
    }

    @Test
    public final void inheritence(){
        Atom atom = new Atom("Wasserstoff", "H", 1);
        Assert.assertNotNull((Element)atom);
    }
}
