package org.poker.service.strategy;

import org.poker.model.Card;
import org.poker.model.Hand;

import java.util.HashSet;
import java.util.Set;

public class TwoPairStrategy implements IHandStrategy {
    @Override
    public boolean appliesTo(final Hand hand) {
        final Set<String> uniqueRanks = new HashSet<>();
        int pairCount = 0;

        for (final Card card : hand.cards()) {
            if (!uniqueRanks.add(card.suit())) {
                pairCount++;
            }
        }

        return pairCount == 2;
    }

    @Override
    public EHand getHand() {
        return EHand.TWO_PAIR;
    }
}
