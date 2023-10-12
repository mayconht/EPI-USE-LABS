package org.poker.service.strategy;

import org.poker.model.Hand;

public interface IHandStrategy {
    boolean appliesTo(Hand hand);

    EHand getHand();
}
