/**
 * This class represents a strategy for identifying a Straight hand in poker.
 * A Straight is a hand where the ranks of the cards form a sequence, but the suits may be mixed.
 * <p>
 * For example, a hand with the cards 2, 3, 4, 5, and 6 (regardless of suit) is a Straight.
 * </p>
 */
package org.poker.service.strategy;

import org.poker.model.Card;
import org.poker.model.Hand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StraightStrategy implements IHandStrategy {
    
    @Override
    public boolean appliesTo(final Hand hand) {
        List<Integer> ranks = new ArrayList<>();
        for (Card card : hand.cards()) {
            ranks.add(Integer.valueOf(card.rank()));
        }

        Collections.sort(ranks);

        for (int i = 0; i < ranks.size() - 1; i++) {
            if (ranks.get(i) + 1 != ranks.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public EHand getHand() {
        return EHand.STRAIGHT;
    }
}
