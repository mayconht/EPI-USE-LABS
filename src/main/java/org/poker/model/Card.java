package org.poker.model;

public record Card(String suit, String rank) {

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + this.suit + '\'' +
                ", rank='" + this.rank + '\'' +
                '}';
    }
}
