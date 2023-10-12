package org.poker.service.strategy;

import org.poker.model.Hand;

public interface IHandEvaluatorStrategy {
    boolean appliesTo(Hand hand);

    String getHandName();
}
