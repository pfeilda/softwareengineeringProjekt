package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.miscellaneous.HighScore;
import com.pfeilda.ajb.miscellaneous.HighScoreInterface;
import com.pfeilda.ajb.particles.AnalysisInterface;
import com.pfeilda.ajb.particles.Element;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BasicAssay extends Assay implements AnalysisAssayInterface {
    /* todo move in baseclass */
    private final Set<Element> markedAsFound;
    private final Date startDate;

    //todo test
    public class AssayAccessor {
        private final BasicAssay assay;
        private final Date evaluateDate;

        private AssayAccessor(final BasicAssay basicAssay) {
            this.assay = basicAssay;
            this.evaluateDate = new Date();
        }

        public long getAssayDuration() {
            return this.evaluateDate.getTime() - this.assay.startDate.getTime();
        }

        public boolean evaluate() {
            return this.assay.evaluate();
        }

        public int getElementsFoundCorrect() {
            return this.countOccurences(this.assay.analysisElements, this.assay.markedAsFound);
        }

        public int notFoundContainingElements() {
            return this.assay.analysisElements.size() - this.getElementsFoundCorrect();
        }

        public int foundNotContainingElements() {
            return
                    this.assay.markedAsFound.size() -
                            this.countOccurences(this.assay.markedAsFound, this.assay.analysisElements);
        }

        public int countOccurences(final Set<Element> shouldContain, final Set<Element> isMarked) {
            int counter = 0;
            for (final Element element :
                    isMarked) {
                if (shouldContain.contains(element)) {
                    counter++;
                }
            }
            return counter;
        }
    }

    public BasicAssay(final Set<Element> analaysisElements) {
        super(analaysisElements);
        this.startDate = new Date();
        this.markedAsFound = new HashSet<>();
    }

    @Override
    public HighScore getScore(final HighScoreInterface highScoreInterface) {
        return highScoreInterface.calculateHighScore(new AssayAccessor(this));
    }

    @Override
    public boolean evaluate() {
        final Set<Element> testSet = new HashSet<>(this.markedAsFound);

        for (final AnalysisInterface element :
                this.analysisElements) {
            if (!testSet.contains(element)) {
                return false;
            }
            testSet.remove(element);
        }

        return testSet.isEmpty();
    }

    @Override
    public void markAsFound(final Element element) {
        this.markedAsFound.add(element);
    }

    @Override
    public void unmarkAsFound(final Element element) {
        this.markedAsFound.remove(element);
    }

    @Override
    public Set<Element> getMarkedElements() {
        return this.markedAsFound;
    }

    @Override
    public boolean isDisruptiveElementPresent(final Set<Element> elements) {
        for (final Element element :
                elements) {
            return this.elements.contains(element);
        }
        return false;
    }

    @Override
    protected AbstractSubstance divideWithOutDeposit() {
        final BasicAssay basicAssay = new BasicAssay(this.analysisElements);
        basicAssay.addAll(this.elements);
        return this.divideWithOutDeposit(basicAssay);
    }

    @Override
    public AbstractSubstance divideWithDeposit() {
        final BasicAssay basicAssay = new BasicAssay(this.deposit);
        basicAssay.addAll(this.deposit);
        this.deposit.clear();
        return this.divideWithOutDeposit(basicAssay);
    }
}
