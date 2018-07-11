package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.miscellaneous.HighScore;
import com.pfeilda.ajb.miscellaneous.HighScoreInterface;
import com.pfeilda.ajb.particles.Element;

import java.util.Set;

public interface AnalysisAssayInterface {
    HighScore getScore(final HighScoreInterface highScoreInterface);

    boolean evaluate();

    void markAsFound(Element element);

    void unmarkAsFound(Element element);

    Set<Element> getMarkedElements();
}
