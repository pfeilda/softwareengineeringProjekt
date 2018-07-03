package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.FileUtility;
import com.pfeilda.ajb.miscellaneous.Singleton;

import java.io.File;
import java.util.Arrays;

public class AtomFactory implements Singleton {
    private static volatile AtomFactory instance;
    private static final Object mutex = new Object();
    private final Atom[] atoms;

    public AtomFactory() {
        final FileUtility fileUtility = FileUtility.getInstance();
        final File atomFile = new File(this.getClass().getResource("/Particles/Atoms.json").getFile());
        this.atoms = fileUtility.readModelFromFile(atomFile, Atom[].class);
        Arrays.sort(this.atoms);
    }

    public static AtomFactory getInstance() {
        AtomFactory result = AtomFactory.instance;
        if (result == null) {
            synchronized (AtomFactory.mutex) {
                result = AtomFactory.instance;
                if (result == null) {
                    AtomFactory.instance = result = new AtomFactory();
                }
            }
        }
        return result;
    }

    public Atom get(final int atomicNumber) {
        final int atomIndex = (atomicNumber - 1);
        if (this.atoms.length > atomIndex && atomIndex >= 0) {
            return this.atoms[atomIndex];
        }
        return null;
    }
}
