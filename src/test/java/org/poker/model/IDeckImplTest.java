package org.poker.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.poker.utils.Constants;

import static org.junit.jupiter.api.Assertions.*;

class IDeckImplTest {

    private IDeckImpl deck;

    @BeforeEach
    void setUp() {
        this.deck = new IDeckImpl();
    }

    @Test
    void dealOneCard() {
        final Card card = this.deck.dealOneCard();
        assertNotNull(card, "Dealt card should not be null");
    }

    @Test
    void dealHand() {
        final int handSize = 5;
        final Hand hand = this.deck.dealHand(handSize);
        assertNotNull(hand, "Dealt hand should not be null");
        assertEquals(handSize, hand.cards().size(), "Dealt hand should contain the requested number of cards");
    }

    @Test
    void dealHand_invalidNumberOfCards() {
        final int invalidHandSize = -5;
        final IllegalStateException exception = assertThrows(IllegalStateException.class, () -> this.deck.dealHand(invalidHandSize));
        assertEquals(Constants.ERROR_WHILE_TRYING_TO_DEAL_HAND, exception.getMessage(), "Exception message should be as expected");
    }
}
