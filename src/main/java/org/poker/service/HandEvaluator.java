package org.poker.service;

import org.poker.model.Hand;
import org.poker.service.strategy.IHandEvaluatorStrategy;
import org.poker.service.strategy.OnePairStrategy;
import org.poker.service.strategy.TwoPairStrategy;

import java.util.Arrays;
import java.util.List;

public class HandEvaluator {

    private final List<IHandEvaluatorStrategy> strategies;

    public HandEvaluator() {
        this.strategies = Arrays.asList(
                new OnePairStrategy(),
                new TwoPairStrategy()
        );
    }

    public void evaluateHand(final Hand hand) {
        for (final IHandEvaluatorStrategy strategy : this.strategies) {
            if (strategy.appliesTo(hand)) {
                System.out.println("HandEvaluator.evaluateHand() called");
                break;
            }
        }
    }
}
