package com.pfeilda.ajb.particles;

public abstract class Element implements AnalysisInterface {
    private final String label;

    Element(final String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public boolean equals(final Object obj) {
        final Element element = (Element) obj;
        return element.getLabel().equals(this.label);
    }
}
