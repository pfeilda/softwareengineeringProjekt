package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.miscellaneous.TestInterface;
import org.junit.Test;

public interface AnalysisTestInterface extends TestInterface {
    @Override
    public abstract AnalysisInterface generateInstanceOfTestClass();

    @Test
    void getMarkedElementsInitialEmpty();

    @Test
    void getMarkedElementsSuccess();

    @Test
    void unmarkElement();

    @Test
    void isEmptyAfterUnmarkingLastElement();

    @Test
    void unmarkElementTwice();

    @Test
    void markElement();

    @Test
    void markElementTwice();

    @Test
    void evaluateSingleCorrect();

    @Test
    void evaluateMultipleCorrect();

    @Test
    void evaluateEmptyCorrect();

    @Test
    void evaluateSingleFailureElementMarkedButNotPresent();

    @Test
    void evaluateSingleFailureElementNotMarkedButPresent();

    @Test
    void evaluateMultipleFailureMarkedButNotPresent();

    @Test
    void evaluateMultipleFailureNotMarkedButPresent();

    //@todo implement highscore and evaluate failure methods
}
