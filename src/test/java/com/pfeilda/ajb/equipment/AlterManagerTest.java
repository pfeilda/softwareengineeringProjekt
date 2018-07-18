package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.miscellaneous.TestInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class AlterManagerTest implements TestInterface {
    @Override
    public AlterManager generateInstanceOfTestClass() {
        return AlterManager.getInstance();
    }

    @Override
    @Test
    public void creation() {
        Assert.assertNotNull(this.generateInstanceOfTestClass());
    }

    @Test
    public void getInitialSpeedValue() {
        final AlterManager alterManager = this.generateInstanceOfTestClass();
        Assert.assertEquals(new AtomicInteger(100).get(), alterManager.getSpeed().get());
    }
}
