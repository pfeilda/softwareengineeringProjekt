package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.miscellaneous.TestInterface;
import com.pfeilda.ajb.particles.Element;
import org.junit.Assert;
import org.junit.Test;

public abstract class AssayTest extends AbstractSubstance implements TestInterface {
    protected Element singleElement;

    protected abstract Assay generateAssayWithSingleElement(Element element);

    @Override
    public abstract Assay generateInstanceOfTestClass();

    @Test
    public void checkForElementSuccess() {
        final Assay assayWithSingleElement = this.generateAssayWithSingleElement(this.singleElement);
        Assert.assertTrue(assayWithSingleElement.isElementPresent(this.singleElement));
    }
}
