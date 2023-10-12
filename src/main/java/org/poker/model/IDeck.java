package org.poker.model;

public interface IDeck {

    Card dealOneCard();

    Hand dealHand(int numberOfCards); //TODO This will allow to change number of cards for different games

}
