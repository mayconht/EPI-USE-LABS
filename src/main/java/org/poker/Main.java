package org.poker;

import org.poker.model.DeckImpl;

public class Main {
    public static void main(final String[] args) {

        final DeckImpl deck = new DeckImpl();
        System.out.println(deck.dealOneCard());
        System.out.println(deck.dealOneCard());
        System.out.println(deck.dealHand(5));
        System.out.println(deck.dealHand(5));
        System.out.println(deck.dealHand(5));

    }
}