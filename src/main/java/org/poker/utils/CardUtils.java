package org.poker.utils;

import org.poker.model.Card;
import org.poker.model.Hand;

public class CardUtils {
    public static int convertRank(final String rank) {
        return switch (rank.toLowerCase()) {
            case "jack" -> 11;
            case "queen" -> 12;
            case "king" -> 13;
            case "ace" -> 14;
            default -> Integer.parseInt(rank);
        };
    }


    public static String formatHand(final Hand hand) {
        final StringBuilder formattedHand = new StringBuilder();
        for (final Card card : hand.cards()) {
            final String suitSymbol = CardUtils.convertSuitNameToSymbol(card.suit());
            formattedHand.append(card.rank()).append(suitSymbol).append(" ");
        }
        return formattedHand.toString().trim();
    }

    private static String convertSuitNameToSymbol(final String suitName) {
        return switch (suitName.toLowerCase()) {
            case "hearts" -> "♥";
            case "diamonds" -> "♦";
            case "spades" -> "♠";
            case "clubs" -> "♣";
            default -> throw new IllegalArgumentException("Unknown suit name: " + suitName);
        };
    }
}


