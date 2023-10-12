package org.poker.service.strategy;

import org.poker.model.Hand;

public class TwoPairStrategy implements IHandStrategy {
    @Override
    public boolean appliesTo(final Hand hand) {
        return true;
    }

    @Override
    public EHand getHand() {
        return EHand.TWO_PAIR;
    }
}
