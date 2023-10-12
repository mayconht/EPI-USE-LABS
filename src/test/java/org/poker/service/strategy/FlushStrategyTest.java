package org.poker.service.strategy;

import org.junit.jupiter.api.Test;
import org.poker.model.Card;
import org.poker.model.Hand;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FlushStrategyTest {

    @Test
    void appliesTo_flushPresent_returnsTrue() {
        final FlushStrategy flushStrategy = new FlushStrategy();

        final boolean result = flushStrategy.appliesTo(new Hand(List.of(
                new Card("2", "Hearts"),
                new Card("3", "Hearts"),
                new Card("4", "Hearts"),
                new Card("5", "Hearts"),
                new Card("6", "Hearts")
        )));

        assertTrue(result);
    }

    @Test
    void appliesTo_flushNotPresent_returnsFalse() {
        final FlushStrategy flushStrategy = new FlushStrategy();

        final boolean result = flushStrategy.appliesTo(new Hand(List.of(
                new Card("2", "Hearts"),
                new Card("3", "Diamonds"),
                new Card("4", "Hearts"),
                new Card("5", "Spades"),
                new Card("6", "Spades")
        )));

        assertFalse(result);
    }
}
