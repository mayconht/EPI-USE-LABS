package org.poker.service.strategy;

import org.poker.model.Hand;
import org.poker.utils.PokerUtils;

public class ThreeOfAKindStrategy implements IHandStrategy {
    @Override
    public boolean appliesTo(final Hand hand) {
        return PokerUtils.countPairs(hand, 3);
    }

    @Override
    public EHand getHand() {
        return EHand.THREE_OF_A_KIND;
    }
}
