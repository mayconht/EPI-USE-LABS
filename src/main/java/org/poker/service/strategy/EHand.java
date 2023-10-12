package org.poker.service.strategy;

public enum EHand {
    ONE_PAIR("One Pair", new OnePairStrategy(), 2),
    TWO_PAIR("Two Pair", new TwoPairStrategy(), 1);

    private final String handName;
    private final IHandStrategy handStrategy;

    private final int rank;

    EHand(final String handName, final IHandStrategy handStrategy, final int rank) {
        this.handName = handName;
        this.handStrategy = handStrategy;
        this.rank = rank;
    }

    public String getHandName() {
        return this.handName;
    }

    public IHandStrategy getHandStrategy() {
        return this.handStrategy;
    }

    public int getRank() {
        return this.rank;
    }
}
