package org.poker.model;

import java.util.List;

public record Hand(List<Card> cards) {

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + this.cards +
                '}';
    }
}
