package org.poker.model;

import java.util.List;

public class HandImpl implements Hand {
    private final List<Card> cards;

    public HandImpl(final List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public HandRank evaluateHand() {
        return HandRank.PAIR; //TODO implement this method
    }

}
