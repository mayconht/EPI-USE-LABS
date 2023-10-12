package org.poker.utils;

public class StringUtils {

    public static String replaceSuit(final String suit) {
        return switch (suit) {
            case "Spades" -> "♠";
            case "Hearts" -> "♥";
            case "Diamonds" -> "♦";
            case "Clubs" -> "♣";
            default -> throw new IllegalStateException("Unexpected value: " + suit);
        };
    }
}
