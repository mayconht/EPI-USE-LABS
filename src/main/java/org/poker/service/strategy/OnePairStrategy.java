package org.poker.service.strategy;

import org.poker.model.Hand;
import org.poker.utils.PokerUtils;

public class OnePairStrategy implements IHandStrategy {
    @Override
    public boolean appliesTo(final Hand hand) {
        return PokerUtils.countPairs(hand, 1);
    }

    @Override
    public EHand getHand() {
        return EHand.ONE_PAIR;
    }
}