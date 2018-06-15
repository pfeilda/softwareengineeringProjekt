package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.analysis.Substance;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Atom extends Element {
    private final String elementSymbol;
    private final int ordinal;

    Atom(@JsonProperty("name") final String label, @JsonProperty("symbol") final String elementSymbol, @JsonProperty("ordinal") final int ordinal) {
        super(label);
        this.elementSymbol = elementSymbol;
        this.ordinal = ordinal;
    }

    public String getElementSymbol() {
        return this.elementSymbol;
    }

    public int getOrdinal() {
        return this.ordinal;
    }

    @Override
    public boolean experimentalProof(final Substance substance) {
        return true;
    }

    //todo remove mock
    public boolean experimentalProof(final boolean mock) {
        return mock;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Atom) {
            if (super.equals(obj)) {
                final Atom atom = (Atom) obj;
                if (this.getElementSymbol().equals(atom.getElementSymbol())) {
                    if (this.getOrdinal() == atom.getOrdinal()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
