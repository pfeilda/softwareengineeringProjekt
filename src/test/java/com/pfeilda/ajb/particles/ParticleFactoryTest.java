package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.TestInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ParticleFactoryTest implements TestInterface {
    private final ArrayList<Atom> atoms = new ArrayList<Atom>();
    private final ArrayList<Ion> ions = new ArrayList<Ion>();
    private final Molecule molecule;

    public ParticleFactoryTest() {
        this.atoms.add(new Atom("Hydrogen", "H", 1));
        this.atoms.add(new Atom("Sauerstoff", "O", 8));

        final Ion hydrogen = new Ion("Hydrogen", this.atoms.subList(0, 1).toArray(new Atom[]{}), 1);
        this.ions.add(hydrogen);
        this.ions.add(hydrogen);

        final Ion oxygen = new Ion("Dioxid", this.atoms.subList(1, 2).toArray(new Atom[]{}), -2);
        this.ions.add(oxygen);

        this.molecule = new Molecule("Wasser", this.ions);
    }

    @Override
    public Object generateInstanceOfTestClass() {
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
    public void generationOfAtoms() {
        final Atom particle = ParticleFactory.getInstance().getAtom(this.atoms.get(0).getOrdinal());
        Assert.assertTrue(this.atoms.get(0).equals(particle));
    }

    @Test
    public void generationOfMolecules() {
        final Molecule particle = ParticleFactory.getInstance().getMolecule(this.molecule.getLabel());
        Assert.assertTrue(this.molecule.equals(particle));
    }
}
