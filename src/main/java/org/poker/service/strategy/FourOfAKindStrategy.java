package org.poker.service.strategy;

import org.poker.model.Card;
import org.poker.model.Hand;

import java.util.HashMap;
import java.util.Map;

public class FourOfAKindStrategy implements IHandStrategy {
    private static final int FOUR_OF_A_KIND_SIZE = 4;

    @Override
    public boolean appliesTo(final Hand hand) {
        final Map<String, Integer> rankCount = new HashMap<>();

        for (final Card card : hand.cards()) {
            final String rank = card.rank();
            int count = rankCount.getOrDefault(rank, 0);
            count++;
            rankCount.put(rank, count);
        }

        for (final Integer count : rankCount.values()) {
            if (count >= FourOfAKindStrategy.FOUR_OF_A_KIND_SIZE) {
                return true;
            }
        }

        return false;
    }


    @Override
    public EHand getHand() {
        return EHand.FOUR_OF_A_KIND;
    }
}
