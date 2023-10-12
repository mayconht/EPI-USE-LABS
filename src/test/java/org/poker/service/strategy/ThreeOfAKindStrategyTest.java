package org.poker.service.strategy;

import org.junit.jupiter.api.Test;
import org.poker.model.Card;
import org.poker.model.Hand;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ThreeOfAKindStrategyTest {

    @Test
    void appliesTo_threeOfAKindPresent_returnsTrue() {
        final ThreeOfAKindStrategy threeOfAKindStrategy = new ThreeOfAKindStrategy();

        final boolean result = threeOfAKindStrategy.appliesTo(new Hand(List.of(
                new Card("2", "Hearts"),
                new Card("2", "Diamonds"),
                new Card("2", "Clubs"),
                new Card("4", "Spades"),
                new Card("6", "Clubs"),
                new Card("3", "Clubs")
        )));

        assertTrue(result);
    }

    @Test
    void appliesTo_threeOfAKindNotPresent_returnsFalse() {
        final ThreeOfAKindStrategy threeOfAKindStrategy = new ThreeOfAKindStrategy();

        final boolean result = threeOfAKindStrategy.appliesTo(new Hand(List.of(
                new Card("2", "Hearts"),
                new Card("3", "Diamonds"),
                new Card("4", "Hearts"),
                new Card("5", "Spades"),
                new Card("6", "Spades")
        )));

        assertFalse(result);
    }
}
