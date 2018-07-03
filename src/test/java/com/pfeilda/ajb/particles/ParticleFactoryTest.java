package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.Singleton;
import com.pfeilda.ajb.miscellaneous.TestInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ParticleFactoryTest implements TestInterface {
    private final ArrayList<Atom> atoms = new ArrayList<>();
    private final ArrayList<Ion> ions = new ArrayList<>();
    private final Molecule molecule;

    public ParticleFactoryTest() {
        this.atoms.add(new Atom("Hydrogen", "H", 1));
        this.atoms.add(new Atom("Oxygen", "O", 8));

        final Ion hydrogen = new Ion("Hydrogen", this.atoms.subList(0, 1).toArray(new Atom[]{}), 1);
        this.ions.add(hydrogen);
        this.ions.add(hydrogen);

        final Ion oxygen = new Ion("Dioxid", this.atoms.subList(1, 2).toArray(new Atom[]{}), -2);
        this.ions.add(oxygen);

        this.molecule = new Molecule("Wasser", this.ions);
    }

    @Override
    public ParticleFactory generateInstanceOfTestClass() {
        return ParticleFactory.getInstance();
    }

    @Override
    @Test
    public void creation() {
        Assert.assertNotNull(this.generateInstanceOfTestClass());
    }

    @Test
    public void getSameInstance() {
        Assert.assertEquals(this.generateInstanceOfTestClass(), ParticleFactory.getInstance());
    }

    @Test
    public final void inheritanceSuccess() {
        final ParticleFactory particleFactory = this.generateInstanceOfTestClass();
        Assert.assertNotNull((Singleton) particleFactory);
    }

    @Test
    public void generationOfAtoms() {
        final ParticleFactory particleFactory = ParticleFactory.getInstance();
        final Atom referenceAtom = this.atoms.get(0);
        final Atom atom = particleFactory.getAtom(referenceAtom.getAtomicNumber());
        Assert.assertEquals(referenceAtom, atom);
    }

    @Test
    public void generationOfUnkownAtomWithAtomicNumberLowerThan1() {
        final ParticleFactory particleFactory = ParticleFactory.getInstance();
        final Atom atom = particleFactory.getAtom(0);
        Assert.assertNull(atom);
    }

    @Test
    public void generationOfUnkownAtomWithAtomicNumberHigherHigherNumberThan119() {
        final ParticleFactory particleFactory = ParticleFactory.getInstance();
        final Atom atom = particleFactory.getAtom(120);
        Assert.assertNull(atom);
    }

    @Test
    public void generationOfIon() {
        final ParticleFactory particleFactory = ParticleFactory.getInstance();
        final Ion referenceIon = this.ions.get(0);
        final Ion ion = particleFactory.getIon(referenceIon.getLabel());
        Assert.assertEquals(referenceIon, ion);
    }

    @Test
    public void generationOfUnkownIon() {
        final ParticleFactory particleFactory = ParticleFactory.getInstance();
        final Ion ion = particleFactory.getIon("unkown");
        Assert.assertNull(ion);
    }

    @Test
    public void generationOfMolecules() {
        final ParticleFactory particleFactory = ParticleFactory.getInstance();
        final Molecule referenceMolecule = this.molecule;
        final Molecule molecule = particleFactory.getMolecule(referenceMolecule.getLabel());
        Assert.assertEquals(referenceMolecule, molecule);
    }

    @Test
    public void generateOfUnkownMolecule() {
        final ParticleFactory particleFactory = ParticleFactory.getInstance();
        final Molecule particle = particleFactory.getMolecule("ungültig");
        Assert.assertNull(particle);
    }
}
