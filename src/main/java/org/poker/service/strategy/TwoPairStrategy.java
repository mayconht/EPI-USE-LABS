package org.poker.service.strategy;

import org.poker.model.Hand;
import org.poker.utils.PokerUtils;

public class TwoPairStrategy implements IHandStrategy {
    @Override
    public boolean appliesTo(final Hand hand) {
        return PokerUtils.countPairs(hand, 2);
    }

    @Override
    public EHand getHand() {
        return EHand.TWO_PAIR;
    }
}
