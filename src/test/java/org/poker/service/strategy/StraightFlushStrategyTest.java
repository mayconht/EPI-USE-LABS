package org.poker.service.strategy;

import org.junit.jupiter.api.Test;
import org.poker.model.Card;
import org.poker.model.Hand;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StraightFlushStrategyTest {

    @Test
    void appliesTo_straightFlushPresent_returnsTrue() {
        final StraightFlushStrategy straightFlushStrategy = new StraightFlushStrategy();

        final boolean result = straightFlushStrategy.appliesTo(new Hand(List.of(
                new Card("2", "Hearts"),
                new Card("3", "Hearts"),
                new Card("4", "Hearts"),
                new Card("5", "Hearts"),
                new Card("6", "Hearts")
        )));

        assertTrue(result);
    }

    @Test
    void appliesTo_straightFlushNotPresent_returnsFalse() {
        final StraightFlushStrategy straightFlushStrategy = new StraightFlushStrategy();

        final boolean result = straightFlushStrategy.appliesTo(new Hand(List.of(
                new Card("2", "Hearts"),
                new Card("4", "Hearts"),
                new Card("6", "Hearts"),
                new Card("8", "Hearts"),
                new Card("10", "Hearts")
        )));

        assertFalse(result);
    }
}
