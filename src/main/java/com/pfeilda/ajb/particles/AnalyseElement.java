package com.pfeilda.ajb.particles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pfeilda.ajb.analysis.Assay;
import com.pfeilda.ajb.miscellaneous.Property;
import com.pfeilda.ajb.miscellaneous.Temperature;

import java.util.*;

public class AnalyseElement implements AnalysisInterface {
    private final Element element;
    private final Set<Element> disruptiveElements;
    private final Set<Deposit> depositElements;
    private final boolean isAnalyzable;

    public AnalyseElement(
            final Element element,
            final Set<Element> disruptiveElements,
            final Set<Deposit> depositElements,
            final boolean isAnalyzable
    ) {
        this.element = element;
        this.disruptiveElements = disruptiveElements;
        this.depositElements = depositElements;
        this.isAnalyzable = isAnalyzable;
    }

    //todo refactore duplicate code
    public AnalyseElement(
            @JsonProperty("type") String type,
            @JsonProperty("element") String element,
            @JsonProperty("disruptiveElements") final Map<String, String[]> disruptiveElements,
            @JsonProperty("depositElements") final Map<String, Map<String, Object>[]> depositElements,
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
            final AtomFactory atomFactory = AtomFactory.getInstance();
            final IonFactory ionFactory = IonFactory.getInstance();
            final MoleculeFactory moleculeFactory = MoleculeFactory.getInstance();

            final Map<String, Object>[] atomIds = depositElements.get("atoms");

            for (final Map<String, Object> atomId :
                    atomIds) {
                final Atom atom = atomFactory.get(Integer.parseInt((String) atomId.get("id")));

                final Map<String, String> afterDeposit = (Map<String, String>) atomId.get("afterDeposit");

                type = afterDeposit.get("type");
                element = afterDeposit.get("id");

                Element depositElement = null;
                if (type.equals("atom")) {
                    depositElement = AtomFactory.getInstance().get(Integer.parseInt(element));
                } else if (type.equals("ion")) {
                    depositElement = IonFactory.getInstance().get(element);
                } else if (type.equals("molecule")) {
                    depositElement = MoleculeFactory.getInstance().get(element);
                }

                final Map<String, Double> properties = (Map<String, Double>) atomId.get("properties");

                final Set<Property> propertySet = new HashSet<>();

                if (properties.containsKey("temperature")) {
                    propertySet.add(new Temperature(properties.get("temperature")));
                }

                this.depositElements.add(new Deposit(atom, depositElement, propertySet));
            }

            final Map<String, Object>[] ionIds = depositElements.get("ions");

            for (final Map<String, Object> ionId :
                    ionIds) {
                final Ion ion = ionFactory.get((String) ionId.get("id"));

                final Map<String, String> afterDeposit = (Map<String, String>) ionId.get("afterDeposit");

                type = afterDeposit.get("type");
                element = afterDeposit.get("id");

                Element depositElement = null;
                if (type.equals("atom")) {
                    depositElement = AtomFactory.getInstance().get(Integer.parseInt(element));
                } else if (type.equals("ion")) {
                    depositElement = IonFactory.getInstance().get(element);
                } else if (type.equals("molecule")) {
                    depositElement = MoleculeFactory.getInstance().get(element);
                }

                final Map<String, Double> properties = (Map<String, Double>) ionId.get("properties");

                final Set<Property> propertySet = new HashSet<>();

                if (properties.containsKey("temperature")) {
                    propertySet.add(new Temperature(properties.get("temperature")));
                }

                this.depositElements.add(new Deposit(ion, depositElement, propertySet));
            }

            final Map<String, Object>[] moleculeIds = depositElements.get("molecules");

            for (final Map<String, Object> moleculeId :
                    moleculeIds) {
                final Molecule molecule = moleculeFactory.get((String) moleculeId.get("id"));

                final Map<String, String> afterDeposit = (Map<String, String>) moleculeId.get("afterDeposit");

                type = afterDeposit.get("type");
                element = afterDeposit.get("id");

                Element depositElement = null;
                if (type.equals("atom")) {
                    depositElement = AtomFactory.getInstance().get(Integer.parseInt(element));
                } else if (type.equals("ion")) {
                    depositElement = IonFactory.getInstance().get(element);
                } else if (type.equals("molecule")) {
                    depositElement = MoleculeFactory.getInstance().get(element);
                }

                final Map<String, Double> properties = (Map<String, Double>) moleculeId.get("properties");

                final Set<Property> propertySet = new HashSet<>();

                if (properties.containsKey("temperature")) {
                    propertySet.add(new Temperature(properties.get("temperature")));
                }

                this.depositElements.add(new Deposit(molecule, depositElement, propertySet));
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

    public final Deposit isDeposite(final Element element) {
        for (final Deposit deposit :
                this.depositElements) {
            if (deposit.isDeposit(element)) {
                return deposit;
            }
        }
        return null;
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

    @Override
    public String toString() {
        return this.get().getLabel();
    }
}
