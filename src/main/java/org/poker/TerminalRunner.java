package org.poker;

import org.poker.model.IDeckImpl;
import org.poker.service.HandEvaluator;

public class TerminalRunner {
    public static final String USAGE = "Usage: java TerminalRunner <number_of_cards> <number_of_hands>";
    public static final String INVALID_INPUT = "Invalid input. Both arguments should be integers.";

    public static void main(final String[] args) {

        if (args.length < 2) {
            System.out.println(TerminalRunner.USAGE);
            return;
        }

        final int numberOfCards;
        final int numberOfHands;

        try {
            numberOfCards = Integer.parseInt(args[0]);
            numberOfHands = Integer.parseInt(args[1]);
        } catch (final NumberFormatException e) {
            System.out.println(TerminalRunner.INVALID_INPUT);
            return;
        }

        final IDeckImpl deck = new IDeckImpl();
        final HandEvaluator handEvaluator = new HandEvaluator();

        for (int i = 0; i < numberOfHands; i++) {
            handEvaluator.evaluateHand(deck.dealHand(numberOfCards));
        }
    }
}
