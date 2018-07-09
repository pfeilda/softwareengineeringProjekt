package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.miscellaneous.TestInterface;
import com.pfeilda.ajb.particles.Element;
import org.junit.Assert;
import org.junit.Test;

public abstract class AssayTest implements TestInterface {
    protected Element singleElement;

    protected abstract Assay generateAssayWithSingleElement(Element element);

    @Test
    public void checkForElementSuccess() {
        final Assay assayWithSingleElement = this.generateAssayWithSingleElement(this.singleElement);
        Assert.assertTrue(assayWithSingleElement.elementIsPresent(this.singleElement));
    }
}
