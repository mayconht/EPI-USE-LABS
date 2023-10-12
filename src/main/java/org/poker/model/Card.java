package org.poker.model;

public record Card(String rank, String suit) {

    @Override
    public String toString() {
        return "%s %s".formatted(this.suit, this.rank);
    }

}
