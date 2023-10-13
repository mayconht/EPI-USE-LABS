package org.poker.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Card(String rank, String suit) {

    @Override
    public String toString() {
        return "%s %s".formatted(this.suit, this.rank);
    }

}
