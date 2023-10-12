package org.poker.service.strategy;

import org.poker.model.Hand;

public class FullHouseStrategy implements IHandStrategy {
    @Override
    public boolean appliesTo(final Hand hand) {
        return false;
    }

    @Override
    public EHand getHand() {
        return EHand.FULL_HOUSE;
    }
}
