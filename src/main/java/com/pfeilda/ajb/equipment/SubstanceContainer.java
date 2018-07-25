package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.analysis.AnalysisAssayInterface;
import com.pfeilda.ajb.analysis.BasicAssay;
import com.pfeilda.ajb.gui.Elements.Partials.AssayOverview;
import com.pfeilda.ajb.miscellaneous.HighScore;
import com.pfeilda.ajb.miscellaneous.HighScoreInterface;
import com.pfeilda.ajb.miscellaneous.Property;
import com.pfeilda.ajb.miscellaneous.Volume;
import com.pfeilda.ajb.particles.AnalyseElement;
import com.pfeilda.ajb.particles.Element;

import java.util.List;
import java.util.function.Consumer;

public abstract class SubstanceContainer implements PartInterface, AlterInterface {
    private final Volume maxVolume;
    protected AssayOverview assayOverview;
    protected final AbstractSubstance abstractSubstance;
    private boolean isCleared = false;

    public SubstanceContainer(final AbstractSubstance abstractSubstance, final Volume maxVolume) {
        this.abstractSubstance = abstractSubstance;
        this.maxVolume = maxVolume;
        this.validateVolume();

        final DefaultAlterProcess defaultAlterProcess = new DefaultAlterProcess();
        defaultAlterProcess.add(this);

        final AlterManager alterManager = AlterManager.getInstance();
        alterManager.addObserver(defaultAlterProcess);
    }

    @Override
    //todo check if really needed
    public void add(final SubstanceContainer substanceContainer) {
        substanceContainer.decant(substanceContainer);
        this.change();
    }

    public Volume getMaxVolume() {
        return this.maxVolume;
    }

    //todo check if cleared is needed
    public boolean isCleared() {
        return this.isCleared;
    }

    public void clear() {
        this.isCleared = true;
    }

    private void decant(final SubstanceContainer substanceContainer) {
        if (this.isAllowed()) {
            substanceContainer.add(this.abstractSubstance);
            substanceContainer.clear();
        }
    }

    public void addTo(final SubstanceContainer substanceContainer) {
        substanceContainer.decant(substanceContainer);
        this.change();
    }

    //todo improve tests
    public void add(final AbstractSubstance abstractSubstance) {
        if (this.isAllowed()) {
            abstractSubstance.addTo(this.abstractSubstance);
            this.validateVolume();
            this.change();
        }
    }

    public void addConsumerToSubstance(final Consumer consumer) {
        this.abstractSubstance.setIsNonValid(consumer);
    }

    public boolean isAllowed() {
        if (this.isCleared() || !this.abstractSubstance.isValid()) {
            return false;
        }
        return true;
    }

    private void validateVolume() {
        if (this.maxVolume.get() < this.abstractSubstance.getVolume().get()) {
            this.abstractSubstance.destroy();
        }
    }

    @Override
    public void alter(final Property[] properties) {
        this.abstractSubstance.alter(properties);
        this.change();
    }

    //todo write test for
    public List<Property> getPropertiesOfSubstances() {
        return this.abstractSubstance.getProperties();
    }

    public abstract SubstanceContainer divide();

    public abstract SubstanceContainer divideWithDeposit();

    public HighScore evaluate(final HighScoreInterface highScoreInterface) {
        return ((AnalysisAssayInterface) this.abstractSubstance).getScore(highScoreInterface);
    }

    public void markAsFound(final Element element) {
        ((AnalysisAssayInterface) this.abstractSubstance).markAsFound(element);
    }

    public void unmarkAsFound(final Element element) {
        ((AnalysisAssayInterface) this.abstractSubstance).unmarkAsFound(element);
    }

    public AssayOverview getView() {
        return this.assayOverview;
    }

    public void change() {
        this.assayOverview.repaint();
    }

    public boolean experimentalProof(final AnalyseElement analyseElement) {
        final BasicAssay basicAssay = (BasicAssay) this.abstractSubstance;
        if (basicAssay != null) {
            return analyseElement.experimentalProof(basicAssay, basicAssay.getAnalysisElements());
        }
        return false;
    }
}
