package com.pfeilda.ajb.equipment;

import org.junit.Assert;
import org.junit.Test;

public class BunsenBurnerTest implements ExternalReagentTest {
    @Override
    public BunsenBurner generateInstanceOfTestClass() {
        return new BunsenBurner();
    }


    @Override
    @Test
    public void creation() {
        Assert.assertNotNull(this.generateInstanceOfTestClass());
    }

    @Override
    @Test
    public void getParentSelf() {
        final BunsenBurner parentBunsenBurner = this.generateInstanceOfTestClass();
        final BunsenBurner childrenBunsenBurner = new BunsenBurner(parentBunsenBurner);
        Assert.assertEquals(parentBunsenBurner, childrenBunsenBurner.getParent());
    }

    @Override
    public void getParentOther() {

    }
}
