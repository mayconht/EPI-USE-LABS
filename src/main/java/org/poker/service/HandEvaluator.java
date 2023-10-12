package org.poker.service;

import org.poker.model.Hand;
import org.poker.service.strategy.EHand;
import org.poker.service.strategy.IHandStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HandEvaluator {

    private final List<IHandStrategy> strategies;

    public HandEvaluator() {
        final List<IHandStrategy> strategyList = new ArrayList<>();
        for (final EHand hand : EHand.values()) {
            strategyList.add(hand.getHandStrategy()); //TODO document will list all classes.
        }
//        order by rank
        strategyList.sort(Comparator.comparingInt(o -> o.getHand().getRank()));
        this.strategies = strategyList;
    }

    public void evaluateHand(final Hand hand) {
        for (final IHandStrategy strategy : this.strategies) {
            if (strategy.appliesTo(hand)) {
                System.out.println("Hand is a " + strategy.getHand().getHandName());
                break;
            }
        }
    }
}
