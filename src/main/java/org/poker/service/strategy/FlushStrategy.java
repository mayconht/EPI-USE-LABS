package org.poker.service.strategy;

import org.poker.model.Card;
import org.poker.model.Hand;

import java.util.HashMap;
import java.util.Map;

public class FlushStrategy implements IHandStrategy {

    private static final int FLUSH_SIZE = 5;

    @Override
    public boolean appliesTo(final Hand hand) {
        final Map<String, Integer> suitCount = new HashMap<>();

        for (final Card card : hand.cards()) {
            final String suit = card.suit();
            int count = suitCount.getOrDefault(suit, 0);
            count++;
            suitCount.put(suit, count);
        }

        for (final Integer count : suitCount.values()) {
            if (count >= FlushStrategy.FLUSH_SIZE) {
                return true;
            }
        }
        return false;
    }

    @Override
    public EHand getHand() {
        return EHand.FLUSH;
    }
}
