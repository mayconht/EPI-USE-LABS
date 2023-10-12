package org.poker.service.strategy;

public enum EHand {
    ONE_PAIR("One Pair", new OnePairStrategy()),
    TWO_PAIR("Two Pair", new TwoPairStrategy());

    private final String handName;
    private final IHandEvaluatorStrategy strategy;

    EHand(final String handName, final IHandEvaluatorStrategy strategy) {
        this.handName = handName;
        this.strategy = strategy;
    }

    public String getHandName() {
        return this.handName;
    }
}
