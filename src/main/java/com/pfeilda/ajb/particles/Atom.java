package com.pfeilda.ajb.particles;

public class Atom extends Element{
    private String elementSymbol;
    private int ordinal;

    public Atom(String label, String elementSymbol, int ordinal) {
        super(label);
        this.elementSymbol = elementSymbol;
        this.ordinal = ordinal;
    }

    @Override
    public boolean experimentalProof() {
        return false;
    }
}
