package org.poker;

import org.poker.model.IDeckImpl;
import org.poker.service.HandEvaluator;

public class TerminalRunner {
    public static void main(final String[] args) {

        final IDeckImpl deck = new IDeckImpl();
        final HandEvaluator hand = new HandEvaluator();

        hand.evaluateHand(deck.dealHand(5));
        hand.evaluateHand(deck.dealHand(5));
        hand.evaluateHand(deck.dealHand(5));
        hand.evaluateHand(deck.dealHand(5));
        hand.evaluateHand(deck.dealHand(5));

    }
}