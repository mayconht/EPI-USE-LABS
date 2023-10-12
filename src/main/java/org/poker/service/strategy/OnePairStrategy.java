package org.poker.service.strategy;

import org.poker.model.Card;
import org.poker.model.Hand;

import java.util.HashSet;
import java.util.Set;

public class OnePairStrategy implements IHandStrategy {
    @Override
    public boolean appliesTo(final Hand hand) {
        final Set<String> cards = new HashSet<>();

        for (final Card card : hand.cards()) {
            if (!cards.add(card.suit())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public EHand getHand() {
        return EHand.ONE_PAIR;
    }
}