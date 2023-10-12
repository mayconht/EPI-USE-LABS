package org.poker.model;

import java.util.List;

public interface IPlayer {

    List<Card> getHand();

    String getName();
}
