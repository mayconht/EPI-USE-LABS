package org.poker.model;

import java.util.List;

public interface Deck {
    void shuffle();

    Card dealOneCard();

    List<Card> dealHand(int numberOfCards); //TODO This will allow to change number of cards for different games

}
