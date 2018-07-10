package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.TestInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DisruptiveElementsTest implements TestInterface {
    private final Element element;

    private final int[] atomicNumbers = new int[]{
            1, 6, 11
    };
    private final String[] ionLabels = new String[]{
            "Oxid", "Hydrogen"
    };
    private final String[] moldeculeLabels = new String[]{
            "Water", "Wasserstoffperoxid"
    };

    private final List<Element> disruptiveElements;

    public DisruptiveElementsTest() {
        final AtomFactory atomFactory = AtomFactory.getInstance();
        final IonFactory ionFactory = IonFactory.getInstance();
        final MoleculeFactory moleculeFactory = MoleculeFactory.getInstance();

        this.element = atomFactory.get(55);

        this.disruptiveElements = new ArrayList<>();
        for (final int atomicNumber :
                this.atomicNumbers) {
            this.disruptiveElements.add(atomFactory.get(atomicNumber));
        }
        for (final String ionLabel :
                this.ionLabels) {
            this.disruptiveElements.add(ionFactory.get(ionLabel));
        }
        for (final String moleculeLabel :
                this.moldeculeLabels) {
            this.disruptiveElements.add(moleculeFactory.get(moleculeLabel));
        }
    }

    @Override
    public DisruptiveElements generateInstanceOfTestClass() {
        return new DisruptiveElements(this.element, this.atomicNumbers, this.ionLabels, this.moldeculeLabels);
    }

    @Override
    @Test
    public void creation() {
        Assert.assertNotNull(this.generateInstanceOfTestClass());
    }

    @Test
    public void isElementDisruptiveSuccess() {
        final DisruptiveElements instanceOfDisruptiveElements = this.generateInstanceOfTestClass();
        for (final Element disruptiveElement :
                this.disruptiveElements) {
            Assert.assertTrue(instanceOfDisruptiveElements.isDisruptive(disruptiveElement));
        }
    }

    @Test
    public void isElementDisruptiveFailure() {
        final DisruptiveElements instanceOfDisruptiveElements = this.generateInstanceOfTestClass();
        final AtomFactory atomFactory = AtomFactory.getInstance();

        Assert.assertFalse(instanceOfDisruptiveElements.isDisruptive(atomFactory.get(24)));
    }

    @Test
    public void getElement() {
        Assert.assertEquals(this.element, this.generateInstanceOfTestClass().getElement());
    }
}
