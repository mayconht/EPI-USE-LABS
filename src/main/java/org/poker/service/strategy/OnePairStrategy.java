package org.poker.service.strategy;

import org.poker.model.Card;
import org.poker.model.Hand;

import java.util.HashMap;
import java.util.Map;

public class OnePairStrategy implements IHandStrategy {

    private static final int PAIR_SIZE = 2;

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

        int pairCount = 0;
        for (final Integer count : rankCount.values()) {
            if (count == OnePairStrategy.PAIR_SIZE) {
                pairCount++;
            }
        }
        return pairCount == 1;
    }

    @Override
    public EHand getHand() {
        return EHand.ONE_PAIR;
    }
}
