package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.miscellaneous.TestInterface;
import org.junit.Assert;
import org.junit.Test;

public class AlterManagerTest implements TestInterface {
    @Override
    public AlterManager generateInstanceOfTestClass() {
        return AlterManager.getInstance();
    }

    @Override
    public void creation() {
        Assert.assertNotNull(this.generateInstanceOfTestClass());
    }
}
