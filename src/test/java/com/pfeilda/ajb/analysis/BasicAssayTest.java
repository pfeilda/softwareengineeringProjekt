package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.particles.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class BasicAssayTest extends AssayTest implements AnalysisTestInterface {
    private final Set<Element> referenceMarkedElements;

    public BasicAssayTest() {
        final AtomFactory atomFactory = AtomFactory.getInstance();
        final IonFactory ionFactory = IonFactory.getInstance();
        final MoleculeFactory moleculeFactory = MoleculeFactory.getInstance();

        this.singleElement = atomFactory.get(6);
        this.referenceMarkedElements = new HashSet<>();
        this.referenceMarkedElements.add(atomFactory.get(9));
        this.referenceMarkedElements.add(this.singleElement);
        this.referenceMarkedElements.add(ionFactory.get("Oxid"));
        this.referenceMarkedElements.add(moleculeFactory.get("Water"));
    }

    @Override
    protected BasicAssay generateAssayWithSingleElement(final Element element) {
        final Set<Element> elementSet = new HashSet<>();
        elementSet.add(element);

        return new BasicAssay(elementSet);
    }

    protected BasicAssay generateAssayWithMultipleElement(final Element[] elements) {
        final Set<Element> elementSet = new HashSet<>();
        for (final Element element :
                elements) {
            elementSet.add(element);
        }

        return new BasicAssay(elementSet);
    }

    @Override
    public BasicAssay generateInstanceOfTestClass() {
        return new BasicAssay(new HashSet<>());
    }

    public BasicAssay generateInstanceOfTestClass(final Set<Element> elements) {
        final BasicAssay basicAssay = new BasicAssay(new HashSet<>());

        for (final Element element :
                elements) {
            basicAssay.markAsFound(element);
        }

        return basicAssay;
    }

    @Override
    @Test
    public void creation() {
        Assert.assertNotNull(this.generateInstanceOfTestClass());
    }

    @Override
    @Test
    public void getMarkedElementsInitialEmpty() {
        final BasicAssay basicAssay = this.generateInstanceOfTestClass();
        final Set<Element> elementSet = basicAssay.getMarkedElements();
        Assert.assertTrue(elementSet.isEmpty());
    }

    @Override
    @Test
    public void getMarkedElementsSuccess() {
        final BasicAssay basicAssay = this.generateInstanceOfTestClass(this.referenceMarkedElements);

        Assert.assertEquals(this.referenceMarkedElements, basicAssay.getMarkedElements());
    }

    @Override
    @Test
    public void unmarkElement() {
        final BasicAssay basicAssay = this.generateInstanceOfTestClass(this.referenceMarkedElements);

        Assert.assertTrue(basicAssay.getMarkedElements().contains(this.singleElement));
        basicAssay.unmarkAsFound(this.singleElement);
        Assert.assertFalse(basicAssay.getMarkedElements().contains(this.singleElement));
    }

    @Override
    public void unmarkElementTwice() {
        final BasicAssay basicAssay = this.generateInstanceOfTestClass(this.referenceMarkedElements);

        Assert.assertTrue(basicAssay.getMarkedElements().contains(this.singleElement));
        basicAssay.unmarkAsFound(this.singleElement);
        Assert.assertFalse(basicAssay.getMarkedElements().contains(this.singleElement));
        basicAssay.unmarkAsFound(this.singleElement);
        Assert.assertFalse(basicAssay.getMarkedElements().contains(this.singleElement));
    }

    @Override
    @Test
    public void isEmptyAfterUnmarkingLastElement() {
        final BasicAssay basicAssay = this.generateInstanceOfTestClass(this.referenceMarkedElements);

        final Set<Element> markedElements = new HashSet<>(basicAssay.getMarkedElements());
        for (final Element element :
                markedElements) {
            basicAssay.unmarkAsFound(element);
        }

        Assert.assertTrue(basicAssay.getMarkedElements().isEmpty());
    }

    @Override
    @Test
    public void markElement() {
        final BasicAssay basicAssay = this.generateInstanceOfTestClass();

        basicAssay.markAsFound(this.singleElement);

        final Set<Element> markedElements = basicAssay.getMarkedElements();
        Assert.assertTrue(markedElements.contains(this.singleElement));
    }

    @Override
    @Test
    public void markElementTwice() {
        final BasicAssay basicAssay = this.generateInstanceOfTestClass();

        basicAssay.markAsFound(this.singleElement);
        basicAssay.markAsFound(this.singleElement);

        final Set<Element> markedElements = basicAssay.getMarkedElements();
        Assert.assertTrue(markedElements.contains(this.singleElement));
    }

    @Override
    @Test
    public void evaluateSingleCorrect() {
        final BasicAssay basicAssay = this.generateAssayWithSingleElement(this.singleElement);
        basicAssay.markAsFound(this.singleElement);

        Assert.assertTrue(basicAssay.evaluate());
    }

    @Override
    @Test
    public void evaluateMultipleCorrect() {
        final Element[] elements = this.referenceMarkedElements.toArray(
                new Element[this.referenceMarkedElements.size()]
        );

        final BasicAssay basicAssay = this.generateAssayWithMultipleElement(elements);

        for (final Element element :
                this.referenceMarkedElements) {
            basicAssay.markAsFound(element);
        }

        Assert.assertTrue(basicAssay.evaluate());
    }

    @Override
    @Test
    public void evaluateEmptyCorrect() {
        final BasicAssay basicAssay = this.generateInstanceOfTestClass();

        Assert.assertTrue(basicAssay.evaluate());
    }

    @Override
    @Test
    public void evaluateSingleFailureElementMarkedButNotPresent() {
        final Set<Element> markedElements = new HashSet<>();
        markedElements.add(this.singleElement);
        final BasicAssay basicAssayElementIsMarkedButNotPresent = this.generateInstanceOfTestClass(markedElements);
        Assert.assertFalse(basicAssayElementIsMarkedButNotPresent.evaluate());
    }

    @Override
    @Test
    public void evaluateSingleFailureElementNotMarkedButPresent() {
        final BasicAssay basicAssayElementIsPresentButNotMarked = this.generateAssayWithSingleElement(
                this.singleElement
        );
        Assert.assertFalse(basicAssayElementIsPresentButNotMarked.evaluate());
    }

    @Override
    @Test
    public void evaluateMultipleFailureMarkedButNotPresent() {
        final BasicAssay basicAssay = this.generateInstanceOfTestClass();

        for (final Element element :
                this.referenceMarkedElements) {
            basicAssay.markAsFound(element);
        }

        Assert.assertFalse(basicAssay.evaluate());
    }

    @Override
    @Test
    public void evaluateMultipleFailureNotMarkedButPresent() {
        final Element[] elements = this.referenceMarkedElements.toArray(
                new Element[this.referenceMarkedElements.size()]
        );

        final BasicAssay basicAssay = this.generateAssayWithMultipleElement(elements);

        Assert.assertFalse(basicAssay.evaluate());
    }
}
