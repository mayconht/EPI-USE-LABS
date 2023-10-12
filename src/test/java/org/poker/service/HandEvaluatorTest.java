package org.poker.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.poker.model.Card;
import org.poker.model.Hand;
import org.poker.utils.CardUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandEvaluatorTest {

    //    reference: https://www.programiz.com/java-programming/bytearrayoutputstream#:~:text=The%20ByteArrayOutputStream%20class%20of%20the,bytes%20to%20store%20the%20data.
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(this.outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(this.originalOut);
    }

    @Test
    void evaluateHand_fullHouseHand_properEvaluation() {
        final HandEvaluator handEvaluator = new HandEvaluator();

        final Hand hand = new Hand(List.of(
                new Card("2", "Hearts"),
                new Card("2", "Clubs"),
                new Card("2", "Diamonds"),
                new Card("3", "Spades"),
                new Card("3", "Hearts")
        ));

        handEvaluator.evaluateHand(hand);
        final String expectedOutput = "Hand: " + CardUtils.formatHand(hand)
                + System.lineSeparator() +
                "Hand is a Full House" + System.lineSeparator();

        assertEquals(expectedOutput, this.outContent.toString());
    }

    @Test
    void evaluateHand_highCardHand_properEvaluation() {
        final HandEvaluator handEvaluator = new HandEvaluator();

        final Hand hand = new Hand(List.of(
                new Card("2", "Hearts"),
                new Card("4", "Clubs"),
                new Card("7", "Diamonds"),
                new Card("10", "Spades"),
                new Card("King", "Hearts")
        ));

        handEvaluator.evaluateHand(hand);
        final String expectedOutput = "Hand: " + CardUtils.formatHand(hand)
                + System.lineSeparator() +
                "Hand is a High Card" + System.lineSeparator();

        assertEquals(expectedOutput, this.outContent.toString());
    }

    @Test
    void evaluateHand_straightHand_properEvaluation() {
        final HandEvaluator handEvaluator = new HandEvaluator();

        final Hand hand = new Hand(List.of(
                new Card("2", "hearts"),
                new Card("3", "clubs"),
                new Card("4", "diamonds"),
                new Card("5", "spades"),
                new Card("6", "hearts")
        ));

        handEvaluator.evaluateHand(hand);
        final String expectedOutput = "Hand: " + CardUtils.formatHand(hand)
                + System.lineSeparator() +
                "Hand is a Straight" + System.lineSeparator();

        assertEquals(expectedOutput, this.outContent.toString());
    }
}
