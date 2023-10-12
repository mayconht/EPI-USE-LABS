package org.poker.service.strategy;

import org.poker.model.Card;
import org.poker.model.Hand;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a strategy for identifying a Full House hand in poker.
 * A Full House is a hand where there is a Three of a Kind and a Pair.
 * For example, a hand with the cards 2, 2, 2, 3, and 3 is a Full House.
 */
public class FullHouseStrategy implements IHandStrategy {
    private static final int THREE_OF_A_KIND_SIZE = 3;
    private static final int PAIR_SIZE = 2;

    @Override
    public boolean appliesTo(final Hand hand) {
        final Map<String, Integer> rankCount = new HashMap<>();
        boolean hasThreeOfAKind = false;
        boolean hasPair = false;

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
            if (count == FullHouseStrategy.THREE_OF_A_KIND_SIZE) {
                hasThreeOfAKind = true;
            } else if (count == FullHouseStrategy.PAIR_SIZE) {
                hasPair = true;
            }
        }
        return hasThreeOfAKind && hasPair;
    }

    @Override
    public EHand getHand() {
        return EHand.FULL_HOUSE;
    }
}
