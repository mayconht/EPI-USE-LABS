package org.poker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class IDeckImpl implements IDeck {
    private final Stack<Card> cards;

    public IDeckImpl() {
        this.cards = new Stack<>();
        initializeDeck();
        shuffle();
    }

    @Override
    public void shuffle() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Shuffling deck...");
            Collections.shuffle(this.cards);
        }
    }

    private void initializeDeck() { //TODO add to properties if I want to change the deck
        final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        final String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (final String suit : suits) {
            for (final String rank : ranks) {
                this.cards.add(new Card(rank, suit));
            }
        }

        System.out.println("Deck created with " + this.cards.size() + " cards");
    }

    @Override
    public Card dealOneCard() {
        return this.cards.pop();
    }

    @Override
    public Hand dealHand(final int numberOfCards) {
        final ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++) {
            cards.add(dealOneCard());
        }
        return new Hand(cards);
    }
}
