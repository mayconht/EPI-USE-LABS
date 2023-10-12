package org.poker.service;

import org.poker.model.Hand;
import org.poker.service.strategy.EHand;
import org.poker.service.strategy.IHandStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HandEvaluator {

    private final List<IHandStrategy> strategies;

    /**
     * HandEvaluator class is responsible for evaluating poker hands using a list of hand strategies.
     * It initializes the strategies list by obtaining the hand strategy for each possible poker hand,
     * sorting them based on their ranks, and storing the sorted list for later evaluation.
     */
    public HandEvaluator() {
        final List<IHandStrategy> strategyList = new ArrayList<>();
        for (final EHand hand : EHand.values()) {
            strategyList.add(hand.getHandStrategy());
        }
        strategyList.sort(Comparator.comparingInt(o -> o.getHand().getRank()));
        this.strategies = strategyList;
    }

    public void evaluateHand(final Hand hand) {
        System.out.println("Evaluating hand: " + hand.cards());
        for (final IHandStrategy strategy : this.strategies) {
            if (strategy.appliesTo(hand)) {
                System.out.println("Hand is a " + strategy.getHand().getHandName());
                break;
            }
        }
    }
}
