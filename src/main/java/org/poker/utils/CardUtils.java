package org.poker.utils;

import org.poker.model.Card;
import org.poker.model.Hand;

public class CardUtils {
    public static int convertRank(final String rank) {
        return switch (rank) {
            case "Jack" -> 11;
            case "Queen" -> 12;
            case "King" -> 13;
            case "Ace" -> 14;
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
            case "heart" -> "♥";
            case "diamond" -> "♦";
            case "spade" -> "♠";
            case "club" -> "♣";
            default -> throw new IllegalArgumentException("Unknown suit name: " + suitName);
        };
    }
}


