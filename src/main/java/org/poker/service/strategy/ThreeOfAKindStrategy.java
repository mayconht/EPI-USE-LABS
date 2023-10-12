package org.poker.service.strategy;

import org.poker.model.Card;
import org.poker.model.Hand;

import java.util.HashMap;
import java.util.Map;

public class ThreeOfAKindStrategy implements IHandStrategy {
    private static final int THREE_OF_A_KIND_SIZE = 3;

    @Override
    public boolean appliesTo(final Hand hand) {
        final Map<String, Integer> rankCount = new HashMap<>();

        for (final Card card : hand.cards()) {
            final String rank = card.rank();
            int count = 0;
            if (rankCount.containsKey(rank)) {
                count = rankCount.get(rank);
            }
            count++;
            rankCount.put(rank, count);
        }

        for (final Integer count : rankCount.values()) {
            if (count == ThreeOfAKindStrategy.THREE_OF_A_KIND_SIZE) {
                return true;
            }
        }
        return false;
    }

    @Override
    public EHand getHand() {
        return EHand.THREE_OF_A_KIND;
    }
}
