//package com.pfeilda.ajb.particles;
//
//import com.pfeilda.ajb.analysis.Assay;
//import com.pfeilda.ajb.analysis.BasicAssay;
//import com.pfeilda.ajb.miscellaneous.TestInterface;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class AnalyseElementTest implements TestInterface {
//    private final Element element;
//    private final Element disruptiveElement;
//    private final Set<Element> disruptiveElements;
//    private final Element depositeElement;
//    private final Element notDepositeElement;
//    private final Set<Element> depositeElements;
//    private boolean isAnalysable = true;
//
//    public AnalyseElementTest() {
//        final AtomFactory atomFactory = AtomFactory.getInstance();
//
//        this.element = atomFactory.get(27);
//        this.disruptiveElement = atomFactory.get(26);
//        this.depositeElement = atomFactory.get(35);
//        this.notDepositeElement = atomFactory.get(1);
//
//        this.disruptiveElements = new HashSet<>();
//        this.disruptiveElements.add(this.disruptiveElement);
//        this.disruptiveElements.add(atomFactory.get(3));
//        this.disruptiveElements.add(atomFactory.get(8));
//
//        this.depositeElements = new HashSet<>();
//        this.depositeElements.add(this.depositeElement);
//        this.depositeElements.add(atomFactory.get(45));
//        this.depositeElements.add(atomFactory.get(20));
//    }
//
//    @Override
//    public AnalyseElement generateInstanceOfTestClass() {
//        return new AnalyseElement(this.element, this.disruptiveElements, this.depositeElements, this.isAnalysable);
//    }
//
//    @Override
//    @Test
//    public void creation() {
//        Assert.assertNotNull(this.generateInstanceOfTestClass());
//    }
//
//    @Test
//    public void experimentalProofTrue() {
//        final Set<Element> elementSet = new HashSet<>();
//        elementSet.add(this.element);
//
//        final Assay referenceAssay = new BasicAssay(elementSet);
//        final AnalyseElement analyseElement = this.generateInstanceOfTestClass();
//
//        Assert.assertTrue(analyseElement.experimentalProof(referenceAssay, elementSet));
//    }
//
//    @Test
//    public void experimentalProofFalse() {
//        final Set<Element> elementSet = new HashSet<>();
//        elementSet.add(this.element);
//
//        final Assay referenceAssay = new BasicAssay(new HashSet<>());
//        final AnalyseElement analyseElement = this.generateInstanceOfTestClass();
//
//        Assert.assertTrue(analyseElement.experimentalProof(referenceAssay, elementSet));
//    }
//
//    @Test
//    public void getElement() {
//        final AnalyseElement analyseElement = this.generateInstanceOfTestClass();
//
//        Assert.assertEquals(this.element, analyseElement.get());
//    }
//
//    @Test
//    public void isAnalysableTrue() {
//        final AnalyseElement analyseElement = this.generateInstanceOfTestClass();
//
//        Assert.assertTrue(analyseElement.isAnalyzable());
//    }
//
//    @Test
//    public void isAnalysableFalse() {
//        this.isAnalysable = false;
//        final AnalyseElement analyseElement = this.generateInstanceOfTestClass();
//
//        Assert.assertFalse(analyseElement.isAnalyzable());
//    }
//
//    @Test
//    public void isDepositeTrue() {
//        final AnalyseElement analyseElement = this.generateInstanceOfTestClass();
//
//        Assert.assertTrue(analyseElement.isDeposite(this.depositeElement));
//    }
//
//    @Test
//    public void isDepositeFalse() {
//        final AnalyseElement analyseElement = this.generateInstanceOfTestClass();
//
//        Assert.assertFalse(analyseElement.isDeposite(this.notDepositeElement));
//    }
//
//    @Test
//    public void equalsMethodCorrect() {
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
//        final AnalyseElement analyseElement1 = new AnalyseElement(
//                element,
//                disruptiveElements,
//                depositElements,
//                isAnalysable
//        );
//        final AnalyseElement analyseElement2 = new AnalyseElement(
//                element,
//                disruptiveElements,
//                depositElements,
//                isAnalysable
//        );
//
//        Assert.assertTrue(analyseElement1.equals(analyseElement2));
//    }
//
//    @Test
//    public void equalsMethodFailsBecauseOfElement() {
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
//        final AnalyseElement analyseElement1 = new AnalyseElement(
//                element,
//                disruptiveElements,
//                depositElements,
//                isAnalysable
//        );
//        final AnalyseElement analyseElement2 = new AnalyseElement(
//                atomFactory.get(3),
//                disruptiveElements,
//                depositElements,
//                isAnalysable
//        );
//
//        Assert.assertFalse(analyseElement1.equals(analyseElement2));
//    }
//
//    @Test
//    public void equalsMethodFailsBecauseOfDisruptiveElements() {
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
//        final AnalyseElement analyseElement1 = new AnalyseElement(
//                element,
//                disruptiveElements,
//                depositElements,
//                isAnalysable
//        );
//        final AnalyseElement analyseElement2 = new AnalyseElement(
//                element,
//                new HashSet<>(),
//                depositElements,
//                isAnalysable
//        );
//
//        Assert.assertFalse(analyseElement1.equals(analyseElement2));
//    }
//
//    @Test
//    public void equalsMethodFailsBecauseOfDepositElements() {
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
//        final AnalyseElement analyseElement1 = new AnalyseElement(
//                element,
//                disruptiveElements,
//                depositElements,
//                isAnalysable
//        );
//        final AnalyseElement analyseElement2 = new AnalyseElement(
//                element,
//                disruptiveElements,
//                new HashSet<>(),
//                isAnalysable
//        );
//
//        Assert.assertFalse(analyseElement1.equals(analyseElement2));
//    }
//
//    @Test
//    public void equalsMethodFailsBecauseOfIsAnalysable() {
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
//        final AnalyseElement analyseElement1 = new AnalyseElement(
//                element,
//                disruptiveElements,
//                depositElements,
//                isAnalysable
//        );
//        final AnalyseElement analyseElement2 = new AnalyseElement(
//                element,
//                disruptiveElements,
//                depositElements,
//                !isAnalysable
//        );
//
//        Assert.assertFalse(analyseElement1.equals(analyseElement2));
//    }
//}
