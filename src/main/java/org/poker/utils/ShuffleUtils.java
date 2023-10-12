package org.poker.utils;

import org.poker.model.Card;

import java.util.Collections;
import java.util.Stack;

public class ShuffleUtils {

    // Reference: https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/
    public static Stack<Card> mathRandomShuffle(final Stack<Card> cards) {
        System.out.println("Shuffling the deck");
        final Stack<Card> shuffledCards = new Stack<>();
        while (!cards.isEmpty()) {
            final int randomIndex = (int) (Math.random() * cards.size());
            shuffledCards.push(cards.remove(randomIndex));
        }
        return shuffledCards;
    }

    public static Stack<Card> collectionShuffle(final Stack<Card> cards) {
        System.out.println("Shuffling the deck");
        Collections.shuffle(cards);
        return cards;
    }


    // Reference: https://en.wikipedia.org/wiki/Shuffling#Riffle
    // Reference:  https://stackoverflow.com/questions/59397518/creating-a-card-shuffling-program-java
    public static Stack<Card> cutAndShuffle(final Stack<Card> cards) {
        final int CUTS = 2;
        System.out.println("Cutting and shuffling the deck");
        for (int cut = 0; cut < CUTS; cut++) {
            int cutPoint = (int) (Math.random() * (cards.size() - 1)) + 1;
            final Stack<Card> top = new Stack<>();
            final Stack<Card> bottom = new Stack<>();
            while (!cards.isEmpty()) {
                if (cutPoint > 0) {
                    top.push(cards.pop());
                    cutPoint--;
                } else {
                    bottom.push(cards.pop());
                }
            }
            cards.addAll(top);
            cards.addAll(bottom);
        }
        return cards;
    }
}
