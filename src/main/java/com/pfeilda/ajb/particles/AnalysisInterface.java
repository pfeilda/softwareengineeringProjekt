package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.analysis.Assay;

import java.util.Set;

public interface AnalysisInterface {
    boolean experimentalProof(final Assay abstractSubstance, Set<Element> analysisElements);
}
