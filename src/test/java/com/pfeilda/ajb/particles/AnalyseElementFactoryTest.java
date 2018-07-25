//package com.pfeilda.ajb.particles;
//
//import com.pfeilda.ajb.miscellaneous.Singleton;
//import com.pfeilda.ajb.miscellaneous.TestInterface;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class AnalyseElementFactoryTest implements TestInterface {
//    @Override
//    public AnalyseElementFactory generateInstanceOfTestClass() {
//        return AnalyseElementFactory.getInstance();
//    }
//
//    @Override
//    @Test
//    public void creation() {
//        Assert.assertNotNull(this.generateInstanceOfTestClass());
//    }
//
//    @Test
//    public void getSameInstance() {
//        Assert.assertEquals(this.generateInstanceOfTestClass(), AnalyseElementFactory.getInstance());
//    }
//
//    @Test
//    public final void inheritanceSuccess() {
//        final AnalyseElementFactory analyseElementFactory = this.generateInstanceOfTestClass();
//        Assert.assertNotNull((Singleton) analyseElementFactory);
//    }
//
//    @Test
//    public void getMethod() {
//        final AtomFactory atomFactory = AtomFactory.getInstance();
//        final IonFactory ionFactory = IonFactory.getInstance();
//        final MoleculeFactory moleculeFactory = MoleculeFactory.getInstance();
//
//        final Element element = atomFactory.get(58);
//        final Set<Element> disruptiveElements = new HashSet<>();
//        final Set<Element> depositElements = new HashSet<>();
//        final boolean isAnalysable = true;
//
//        disruptiveElements.add(atomFactory.get(55));
//
//        depositElements.add(atomFactory.get(1));
//        depositElements.add(ionFactory.get("Hydrogen"));
//        depositElements.add(moleculeFactory.get("Water"));
//
//        final AnalyseElement referenceElement = new AnalyseElement(element, disruptiveElements, depositElements, isAnalysable);
//        final AnalyseElement analyseElement = this.generateInstanceOfTestClass().get(element);
//
//        Assert.assertTrue(referenceElement.equals(analyseElement));
//    }
//}
