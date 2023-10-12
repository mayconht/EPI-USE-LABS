package org.poker.model;

import java.util.List;

public interface Player {
    void setHand(Hand hand);

    List<Card> getHand();

    String getName();
}
