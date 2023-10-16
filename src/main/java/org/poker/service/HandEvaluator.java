package org.poker.service;

import org.poker.model.Hand;
import org.poker.service.strategy.EHand;
import org.poker.service.strategy.IHandStrategy;
import org.poker.utils.CardUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Component
public class HandEvaluator {

    private final List<IHandStrategy> strategies;

    /**
     * Reference: https://www.baeldung.com/java-strategy-pattern
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

    public Map<Hand, String> evaluateHand(final Hand hand) {
        System.out.println("Hand: " + CardUtils.formatHand(hand));
        String handName = "";
        for (final IHandStrategy strategy : this.strategies) {
            if (strategy.appliesTo(hand)) {
                handName = strategy.getHand().getHandName();
                System.out.println("Hand is a " + strategy.getHand().getHandName());
                break;
            }
        }
        return Map.of(hand, handName);
    }
}
