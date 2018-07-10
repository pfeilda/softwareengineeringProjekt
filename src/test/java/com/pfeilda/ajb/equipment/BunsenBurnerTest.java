package com.pfeilda.ajb.equipment;

import org.junit.Assert;
import org.junit.Test;

public class BunsenBurnerTest extends ExternalReagentTest {
    @Override
    public BunsenBurner generateInstanceOfTestClass() {
        return new BunsenBurner();
    }
    
    @Override
    public BunsenBurner generateInstanceOfTestClass(final ExternalReagent externalReagent) {
        return new BunsenBurner(externalReagent);
    }

    @Override
    @Test
    public void creation() {
        Assert.assertNotNull(this.generateInstanceOfTestClass());
    }
}
