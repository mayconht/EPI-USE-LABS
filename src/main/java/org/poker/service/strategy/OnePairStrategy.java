package org.poker.service.strategy;

import org.poker.model.Hand;

public class OnePairStrategy implements IHandEvaluatorStrategy {
    @Override
    public boolean appliesTo(final Hand hand) {
        System.out.println("OnePairStrategy.appliesTo() called");
        return true; //TODO implement
    }

    @Override
    public String getHandName() {
        return "One Pair";
    }
}
