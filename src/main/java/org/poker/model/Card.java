package org.poker.model;

public record Card(String suit, String rank) {

    @Override
    public String toString() {
        return "%s %s".formatted(this.suit, this.rank);

    }
}
