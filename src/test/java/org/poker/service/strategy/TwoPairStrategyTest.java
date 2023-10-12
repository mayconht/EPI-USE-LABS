package org.poker.service.strategy;

import org.junit.jupiter.api.Test;
import org.poker.model.Card;
import org.poker.model.Hand;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TwoPairStrategyTest {

    @Test
    void appliesTo_twoPairPresent_returnsTrue() {
        final TwoPairStrategy twoPairStrategy = new TwoPairStrategy();

        final boolean result = twoPairStrategy.appliesTo(new Hand(List.of(
                new Card("2", "Hearts"),
                new Card("2", "Diamonds"),
                new Card("4", "Hearts"),
                new Card("4", "Spades"),
                new Card("6", "Clubs"),
                new Card("3", "Clubs")
        )));

        assertTrue(result);
    }

    @Test
    void appliesTo_twoPairNotPresent_returnsFalse() {
        final TwoPairStrategy twoPairStrategy = new TwoPairStrategy();

        final boolean result = twoPairStrategy.appliesTo(new Hand(List.of(
                new Card("H2", "Hearts"),
                new Card("D3", "Diamonds"),
                new Card("H4", "Hearts"),
                new Card("S5", "Spades"),
                new Card("S6", "Spades")
        )));

        assertFalse(result);
    }
}
