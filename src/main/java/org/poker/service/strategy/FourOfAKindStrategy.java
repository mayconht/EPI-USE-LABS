package org.poker.service.strategy;

import org.poker.model.Hand;
import org.poker.utils.PokerUtils;

public class FourOfAKindStrategy implements IHandStrategy {
    @Override
    public boolean appliesTo(final Hand hand) {
        return PokerUtils.countPairs(hand, 4);
    }

    @Override
    public EHand getHand() {
        return EHand.FOUR_OF_A_KIND;
    }
}
