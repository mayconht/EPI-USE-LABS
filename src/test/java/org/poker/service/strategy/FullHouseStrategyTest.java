package org.poker.service.strategy;

import org.junit.jupiter.api.Test;
import org.poker.model.Card;
import org.poker.model.Hand;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FullHouseStrategyTest {

    @Test
    void appliesTo_fullHousePresent_returnsTrue() {
        final FullHouseStrategy fullHouseStrategy = new FullHouseStrategy();

        final boolean result = fullHouseStrategy.appliesTo(new Hand(List.of(
                new Card("2", "Hearts"),
                new Card("2", "Clubs"),
                new Card("2", "Diamonds"),
                new Card("3", "Spades"),
                new Card("3", "Hearts")
        )));

        assertTrue(result);
    }

    @Test
    void appliesTo_fullHouseNotPresent_returnsFalse() {
        final FullHouseStrategy fullHouseStrategy = new FullHouseStrategy();

        final boolean result = fullHouseStrategy.appliesTo(new Hand(List.of(
                new Card("2", "Hearts"),
                new Card("3", "Diamonds"),
                new Card("4", "Hearts"),
                new Card("5", "Clubs"),
                new Card("6", "Spades")
        )));

        assertFalse(result);
    }
}
