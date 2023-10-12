package org.poker;

import org.poker.model.IDeckImpl;
import org.poker.service.HandEvaluator;
import org.poker.service.strategy.EHand;

public class Main {
    public static void main(final String[] args) {

        final IDeckImpl deck = new IDeckImpl();
        final HandEvaluator hand = new HandEvaluator();

        for (final EHand eHand : EHand.values()) {
            System.out.println(eHand);
            hand.evaluateHand(deck.dealHand(5));
        }
    }
}