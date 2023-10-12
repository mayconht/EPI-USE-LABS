package org.poker.utils;

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
}
