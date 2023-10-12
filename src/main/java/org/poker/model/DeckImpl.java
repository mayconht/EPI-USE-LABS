package org.poker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DeckImpl implements Deck {
    private final Stack<Card> cards;

    public DeckImpl() {
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
    public List<Card> dealHand(final int numberOfCards) {
        final List<Card> hand = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++) {
            hand.add(this.cards.pop());
        }
        return hand;
    }
}
