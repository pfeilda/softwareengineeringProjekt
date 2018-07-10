package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.TestInterface;
import org.junit.Assert;
import org.junit.Test;

public class DisruptiveElementsFactoryTest implements TestInterface {
    @Override
    public DisruptiveElementsFactory generateInstanceOfTestClass() {
        return DisruptiveElementsFactory.getInstance();
    }

    @Override
    @Test
    public void creation() {
        Assert.assertNotNull(this.generateInstanceOfTestClass());
    }
}
