package org.poker.model;

import org.poker.utils.ShuffleUtils;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;

public class IDeckImpl implements IDeck {
    private final Stack<Card> cards;

    public IDeckImpl() {
        this.cards = new Stack<>();
        initializeGame();
    }

    private void initializeGame() {
        initializeDeck();
        Stack<Card> shuffledCards = ShuffleUtils.collectionShuffle(this.cards);
        shuffledCards = ShuffleUtils.cutAndShuffle(shuffledCards);
        shuffledCards = ShuffleUtils.mathRandomShuffle(shuffledCards);

        this.cards.clear();
        this.cards.addAll(shuffledCards);
    }


    private void initializeDeck() { //TODO add to properties if I want to change the deck
        final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        final String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        this.cards.clear();
        for (final String suit : suits) {
            for (final String rank : ranks) {
                this.cards.add(new Card(rank, suit));
            }
        }

        System.out.println("Deck created with " + this.cards.size() + " cards");
    }

    @Override
    public Card dealOneCard() {
        try {
            if (this.cards.isEmpty()) {
                System.out.println("Deck is empty, shuffling and dealing again");
                initializeDeck();
            }
            return this.cards.pop();
        } catch (final NoSuchElementException e) {
            throw new IllegalStateException("Deck is empty even after shuffle");
        }
    }

    @Override
    public Hand dealHand(final int numberOfCards) {
        try {
            if (numberOfCards <= 0) {
                throw new IllegalArgumentException("Invalid number of cards");
            }
            if (this.cards.size() < numberOfCards) {
                System.out.println("Not enough cards in the deck. Shuffling and dealing again.");
                initializeGame();
            }

            final ArrayList<Card> cards = new ArrayList<>();
            for (int i = 0; i < numberOfCards; i++) {
                cards.add(dealOneCard());
            }
            return new Hand(cards);
        } catch (final Exception e) {
            throw new IllegalStateException("Error while trying to deal Hand", e);
        }
    }
}
