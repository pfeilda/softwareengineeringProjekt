package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.miscellaneous.TestInterface;
import org.junit.Assert;
import org.junit.Test;

public abstract class ExternalReagentTest implements TestInterface {
    public abstract ExternalReagent generateInstanceOfTestClass(ExternalReagent externalReagent);

    @Override
    public abstract ExternalReagent generateInstanceOfTestClass();

    @Test
    public void getParentSelf() {
        final ExternalReagent parentExternalReagent = this.generateInstanceOfTestClass();
        final ExternalReagent childrenExternalReagent = this.generateInstanceOfTestClass(parentExternalReagent);
        Assert.assertEquals(parentExternalReagent, childrenExternalReagent.getParent());
    }

    @Test
    public void getParentOther() {
        final ExternalReagent parentExternalReagent = this.generateInstanceOfTestClass();
        final ExternalReagent childrenExternalReagent = this.generateInstanceOfTestClass(parentExternalReagent);
        final ExternalReagent referenceOtherExternalReagent = this.generateInstanceOfTestClass();
        Assert.assertEquals(referenceOtherExternalReagent, childrenExternalReagent.getParent());
    }
}
