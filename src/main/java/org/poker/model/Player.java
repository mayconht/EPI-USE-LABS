package org.poker.model;

import java.util.List;

public interface Player {

    List<Card> getHand();

    String getName();
}
