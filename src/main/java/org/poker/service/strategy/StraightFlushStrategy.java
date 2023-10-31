package org.poker.service.strategy;

import org.poker.model.Card;
import org.poker.model.Hand;
import org.poker.utils.CardUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * This class represents a strategy for identifying a Straight Flush hand in poker.
 * A Straight Flush is a hand where all cards are of the same suit and their ranks form a sequence.
 * For example, a hand with the cards 2, 3, 4, 5, and 6 of Hearts is a Straight Flush.
 */
public class StraightFlushStrategy implements IHandStrategy {

    @Override
    public boolean appliesTo(final Hand hand) {
        final String suit = hand.cards().get(0).suit();

        for (final Card card : hand.cards()) {
            if (!card.suit().equals(suit)) {
                return false;
            }
        }
        
        final List<Integer> ranks = new ArrayList<>();
        for (final Card card : hand.cards()) {
            ranks.add(CardUtils.convertRank(card.rank()));
        }

        if (!ranks.contains(13) && ranks.contains(14)) {
            ranks.remove(ranks.indexOf(14));
            ranks.add(1);
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
        return EHand.STRAIGHT_FLUSH;
    }
}
