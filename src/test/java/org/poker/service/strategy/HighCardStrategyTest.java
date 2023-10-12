package org.poker.service.strategy;

import org.junit.jupiter.api.Test;
import org.poker.model.Card;
import org.poker.model.Hand;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HighCardStrategyTest {

    @Test
    void appliesTo_highCardPresent_returnsTrue() {
        final HighCardStrategy highCardStrategy = new HighCardStrategy();

        final boolean result = highCardStrategy.appliesTo(new Hand(List.of(
                new Card("2", "Hearts"),
                new Card("4", "Clubs"),
                new Card("7", "Diamonds"),
                new Card("10", "Spades"),
                new Card("King", "Hearts")
        )));

        assertTrue(result);
    }
}
