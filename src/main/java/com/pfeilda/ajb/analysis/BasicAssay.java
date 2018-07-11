package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.miscellaneous.HighScore;
import com.pfeilda.ajb.miscellaneous.HighScoreInterface;
import com.pfeilda.ajb.particles.AnalysisInterface;
import com.pfeilda.ajb.particles.Element;

import java.util.HashSet;
import java.util.Set;

public class BasicAssay extends Assay implements AnalysisAssayInterface {
    private final Set<Element> markedAsFound;

    public BasicAssay(final Set<Element> analaysisElements) {
        super(analaysisElements);
        this.markedAsFound = new HashSet<>();
    }

    @Override
    public HighScore getScore(final HighScoreInterface highScoreInterface) {
        return null;
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
        return this.elements.containsAll(elements);
    }
}
