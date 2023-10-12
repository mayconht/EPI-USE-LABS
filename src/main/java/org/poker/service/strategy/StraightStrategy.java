package org.poker.service.strategy;

import org.poker.model.Hand;

public class StraightStrategy implements IHandStrategy {
    @Override
    public boolean appliesTo(final Hand hand) {
        return false;
    }

    @Override
    public EHand getHand() {
        return EHand.STRAIGHT;
    }
}
