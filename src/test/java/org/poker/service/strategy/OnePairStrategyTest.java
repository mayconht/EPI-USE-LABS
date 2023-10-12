package org.poker.service.strategy;

import org.junit.jupiter.api.Test;
import org.poker.model.Card;
import org.poker.model.Hand;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OnePairStrategyTest {

    @Test
    void appliesTo_onePairPresent_returnsTrue() {
        final OnePairStrategy onePairStrategy = new OnePairStrategy();

        final boolean result = onePairStrategy.appliesTo(new Hand(List.of(
                new Card("2", "Hearts"),
                new Card("2", "Clubs"),
                new Card("3", "Diamonds"),
                new Card("4", "Spades"),
                new Card("5", "Hearts"),
                new Card("6", "Clubs")
        )));

        assertTrue(result);
    }

    @Test
    void appliesTo_onePairNotPresent_returnsFalse() {
        final OnePairStrategy onePairStrategy = new OnePairStrategy();

        final boolean result = onePairStrategy.appliesTo(new Hand(List.of(
                new Card("2", "Hearts"),
                new Card("3", "Diamonds"),
                new Card("4", "Hearts"),
                new Card("5", "Clubs"),
                new Card("6", "Spades"),
                new Card("7", "Clubs")
        )));

        assertFalse(result);
    }
}
