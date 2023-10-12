package org.poker.utils;

import org.poker.model.Card;
import org.poker.model.Hand;

import java.util.HashSet;
import java.util.Set;

public class PokerUtils {
    public static boolean countPairs(final Hand hand, final int desiredPairCount) {
        final Set<String> uniqueRanks = new HashSet<>();
        int pairCount = 0;

        for (final Card card : hand.cards()) {
            if (!uniqueRanks.add(card.suit())) {
                pairCount++;
            }
        }
        return pairCount == desiredPairCount;
    }
}

