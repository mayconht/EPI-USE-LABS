package org.poker.service.strategy;

public enum EHand {
    // 1. Straight Flush
//2. Four of a Kind
//3. Full House
//4. Flush
//5. Straight
//6. Three of a Kind
//7. Two Pair
//8. One Pair
//9. High Cards
    STRAIGHT_FLUSH("Straight Flush", new StraightFlushStrategy(), 1),
    FOUR_OF_A_KIND("Four of a Kind", new FourOfAKindStrategy(), 2),
    FULL_HOUSE("Full House", new FullHouseStrategy(), 3),
    FLUSH("Flush", new FlushStrategy(), 4),
    STRAIGHT("Straight", new StraightStrategy(), 5),
    THREE_OF_A_KIND("Three of a Kind", new ThreeOfAKindStrategy(), 6),
    TWO_PAIR("Two Pair", new TwoPairStrategy(), 7),
    ONE_PAIR("One Pair", new OnePairStrategy(), 8),
    HIGH_CARD("High Card", new HighCardStrategy(), 9);
    
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
