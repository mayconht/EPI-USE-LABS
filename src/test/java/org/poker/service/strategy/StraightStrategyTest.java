package org.poker.service.strategy;

import org.junit.jupiter.api.Test;
import org.poker.model.Card;
import org.poker.model.Hand;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StraightStrategyTest {
    @Test
    void appliesTo_straightPresent_returnsTrue() {
        final StraightStrategy straightStrategy = new StraightStrategy();

        final boolean result = straightStrategy.appliesTo(new Hand(List.of(
                new Card("2", "Hearts"),
                new Card("3", "Clubs"),
                new Card("4", "Diamonds"),
                new Card("5", "Spades"),
                new Card("6", "Hearts")
        )));

        assertTrue(result);
    }

    @Test
    void appliesTo_straightNotPresent_returnsFalse() {
        final StraightStrategy straightStrategy = new StraightStrategy();

        final boolean result = straightStrategy.appliesTo(new Hand(List.of(
                new Card("2", "Hearts"),
                new Card("4", "Clubs"),
                new Card("6", "Diamonds"),
                new Card("8", "Spades"),
                new Card("10", "Hearts")
        )));

        assertFalse(result);
    }
}
