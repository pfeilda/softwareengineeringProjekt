package com.pfeilda.ajb.particles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pfeilda.ajb.analysis.Assay;

import java.util.*;

public class AnalyseElement implements AnalysisInterface {
    private final Element element;
    private final Set<Element> disruptiveElements;
    private final Set<Element> depositElements;
    private final boolean isAnalyzable;

    public AnalyseElement(
            final Element element,
            final Set<Element> disruptiveElements,
            final Set<Element> depositElements,
            final boolean isAnalyzable
    ) {
        this.element = element;
        this.disruptiveElements = disruptiveElements;
        this.depositElements = depositElements;
        this.isAnalyzable = isAnalyzable;
    }

    //todo refactore duplicate code
    public AnalyseElement(
            @JsonProperty("type") final String type,
            @JsonProperty("element") final String element,
            @JsonProperty("disruptiveElements") final Map<String, String[]> disruptiveElements,
            @JsonProperty("depositElements") final Map<String, String[]> depositElements,
            @JsonProperty("isAnalysable") final boolean isAnalyzable
    ) {
        Element requestedElement = null;
        if (type.equals("atom")) {
            requestedElement = AtomFactory.getInstance().get(Integer.parseInt(element));
        } else if (type.equals("ion")) {
            requestedElement = IonFactory.getInstance().get(element);
        } else if (type.equals("molecule")) {
            requestedElement = MoleculeFactory.getInstance().get(element);
        }
        this.element = requestedElement;

        this.disruptiveElements = new HashSet<>();
        {

            final String[] atomIds = disruptiveElements.get("atoms");
            final AtomFactory atomFactory = AtomFactory.getInstance();
            for (final String atomId :
                    atomIds) {
                this.disruptiveElements.add(atomFactory.get(Integer.parseInt(atomId)));
            }
            final String[] ionIds = disruptiveElements.get("ions");
            final IonFactory ionFactory = IonFactory.getInstance();
            for (final String ionId :
                    ionIds) {
                this.disruptiveElements.add(ionFactory.get(ionId));
            }
            final String[] moleculeIds = disruptiveElements.get("molecules");
            final MoleculeFactory moleculeFactory = MoleculeFactory.getInstance();
            for (final String moleculeId :
                    moleculeIds) {
                this.disruptiveElements.add(moleculeFactory.get(moleculeId));
            }
        }

        {
            this.depositElements = new HashSet<>();
            final String[] atomIds = depositElements.get("atoms");
            final AtomFactory atomFactory = AtomFactory.getInstance();
            for (final String atomId :
                    atomIds) {
                this.depositElements.add(atomFactory.get(Integer.parseInt(atomId)));
            }
            final String[] ionIds = depositElements.get("ions");
            final IonFactory ionFactory = IonFactory.getInstance();
            for (final String ionId :
                    ionIds) {
                this.depositElements.add(ionFactory.get(ionId));
            }
            final String[] moleculeIds = depositElements.get("molecules");
            final MoleculeFactory moleculeFactory = MoleculeFactory.getInstance();
            for (final String moleculeId :
                    moleculeIds) {
                this.depositElements.add(moleculeFactory.get(moleculeId));
            }
        }

        this.isAnalyzable = isAnalyzable;
    }

    public final Element get() {
        return this.element;
    }

    public boolean isAnalyzable() {
        return this.isAnalyzable;
    }

    @Override
    public boolean experimentalProof(final Assay abstractSubstance, final Set<Element> analysisElements) {
        if (!abstractSubstance.isDisruptiveElementPresent(this.disruptiveElements)) {
            for (final AnalysisInterface analysisElement :
                    analysisElements) {
                if (this.element.equals(analysisElement)) {
                    return true;
                }
            }
            return false;
        }
        final Random random = new Random();
        return random.nextBoolean();
    }

    public final boolean isDeposite(final Element element) {
        return this.depositElements.contains(element);
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof AnalyseElement) {
            final AnalyseElement analyseElement = (AnalyseElement) obj;
            if (analyseElement.isAnalyzable() == this.isAnalyzable) {
                if (Arrays.equals(analyseElement.depositElements.toArray(), this.depositElements.toArray())) {
                    if (Arrays.equals(analyseElement.disruptiveElements.toArray(), this.disruptiveElements.toArray())) {
                        return analyseElement.element == this.element;
                    }
                }
            }
        }
        return false;
    }
}
