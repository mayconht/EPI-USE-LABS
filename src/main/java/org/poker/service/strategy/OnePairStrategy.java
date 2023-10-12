package org.poker.service.strategy;

import org.poker.model.Hand;

public class OnePairStrategy implements IHandStrategy {
    @Override
    public boolean appliesTo(final Hand hand) {
        return true;
    }

    @Override
    public EHand getHand() {
        return EHand.ONE_PAIR;
    }
}
