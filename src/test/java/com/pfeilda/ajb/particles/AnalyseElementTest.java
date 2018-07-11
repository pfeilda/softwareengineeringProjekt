package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.analysis.Assay;
import com.pfeilda.ajb.analysis.BasicAssay;
import com.pfeilda.ajb.miscellaneous.TestInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class AnalyseElementTest implements TestInterface {
    private final Element element;
    private final Set<Element> disruptiveElements;

    public AnalyseElementTest() {
        final AtomFactory atomFactory = AtomFactory.getInstance();
        this.element = atomFactory.get(27);
        this.disruptiveElements = new HashSet<>();
        this.disruptiveElements.add(atomFactory.get(26));
    }

    @Override
    public AnalyseElement generateInstanceOfTestClass() {
        return new AnalyseElement(this.element, this.disruptiveElements);
    }

    @Override
    @Test
    public void creation() {
        Assert.assertNotNull(this.generateInstanceOfTestClass());
    }

    @Test
    public void experimentalProof() {
        final Set<Element> elementSet = new HashSet<>();
        elementSet.add(this.element);

        final Assay referenceAssay = new BasicAssay(elementSet);
        final AnalyseElement analyseElement = this.generateInstanceOfTestClass();

        Assert.assertTrue(analyseElement.experimentalProof(referenceAssay, elementSet));
    }
}
