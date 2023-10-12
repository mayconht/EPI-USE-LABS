package org.poker.service.strategy;

import org.poker.model.Hand;

public class HighCardStrategy implements IHandStrategy {
    @Override
    public boolean appliesTo(final Hand hand) {
        return true;
    }

    @Override
    public EHand getHand() {
        return EHand.HIGH_CARD;
    }
}
