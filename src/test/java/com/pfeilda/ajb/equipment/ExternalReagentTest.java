package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.miscellaneous.TestInterface;
import org.junit.Assert;

public abstract class ExternalReagentTest implements TestInterface {
    public abstract ExternalReagent generateInstanceOfTestClass(ExternalReagent externalReagent);

    @Override
    public abstract ExternalReagent generateInstanceOfTestClass();

    public void getParentSelf() {
        final ExternalReagent parentExternalReagent = this.generateInstanceOfTestClass();
        final ExternalReagent childrenExternalReagent = this.generateInstanceOfTestClass(parentExternalReagent);
        Assert.assertEquals(parentExternalReagent, childrenExternalReagent.getParent());
    }

    public void getParentOther() {

    }
}
