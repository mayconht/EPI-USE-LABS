package org.poker.model;

import org.poker.utils.ConfigReader;
import org.poker.utils.Constants;
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


    private void initializeDeck() {
        final ConfigReader configReader = new ConfigReader();
        final String[] ranks = configReader.getRanks();
        final String[] suits = configReader.getSuits();
        this.cards.clear();
        for (final String suit : suits) {
            for (final String rank : ranks) {
                this.cards.add(new Card(rank, suit));
            }
        }
    }

    @Override
    public Card dealOneCard() {
        try {
            if (this.cards.isEmpty()) {
                System.out.println(Constants.DECK_IS_EMPTY_SHUFFLING_AND_DEALING_AGAIN);
                initializeDeck();
            }
            return this.cards.pop();
        } catch (final NoSuchElementException e) {
            throw new IllegalStateException(Constants.DECK_IS_EMPTY_EVEN_AFTER_SHUFFLE);
        }
    }

    @Override
    public Hand dealHand(final int numberOfCards) {
        try {
            if (numberOfCards <= 0) {
                throw new IllegalStateException(Constants.INVALID_NUMBER_OF_CARDS);
            }
            if (this.cards.size() < numberOfCards) {
                System.out.println(Constants.NOT_ENOUGH_CARDS_IN_THE_DECK_SHUFFLING_AND_DEALING_AGAIN);
                initializeGame();
            }

            final ArrayList<Card> cards = new ArrayList<>();
            for (int i = 0; i < numberOfCards; i++) {
                cards.add(dealOneCard());
            }
            return new Hand(cards);
        } catch (final Exception e) {
            throw new IllegalStateException(Constants.ERROR_WHILE_TRYING_TO_DEAL_HAND, e);
        }
    }
}
