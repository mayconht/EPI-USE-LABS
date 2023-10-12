package org.poker.service.strategy;

import org.poker.model.Hand;

public class TwoPairStrategy implements IHandEvaluatorStrategy {
    @Override
    public boolean appliesTo(final Hand hand) {
        System.out.println("TwoPairStrategy.appliesTo() called");
        return true;
    }

    @Override
    public String getHandName() {
        return "Two Pair";
    }
}
