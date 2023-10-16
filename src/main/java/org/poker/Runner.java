package org.poker;

import org.poker.model.IDeckImpl;
import org.poker.service.HandEvaluator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Runner {

    public static final String USAGE = "Usage: java TerminalRunner <number_of_cards> <number_of_hands> or java -jar poker-1.0-SNAPSHOT.jar spring";
    public static final String INVALID_INPUT = "Invalid input. Both arguments should be integers.";

    public static void main(final String[] args) {
        if (args.length == 0) {
            System.out.println(Runner.USAGE);
            return;
        }

        if ("spring".equals(args[0])) {
            SpringApplication.run(Runner.class, args);
        } else {
            Runner.runTerminal(args);
        }
    }

    public static void runTerminal(final String[] args) {
        if (args.length < 2) {
            System.out.println(Runner.USAGE);
            return;
        }

        final int numberOfCards;
        final int numberOfHands;

        try {
            numberOfCards = Integer.parseInt(args[0]);
            numberOfHands = Integer.parseInt(args[1]);
        } catch (final NumberFormatException e) {
            System.out.println(Runner.INVALID_INPUT);
            return;
        }

        final IDeckImpl deck = new IDeckImpl();
        final HandEvaluator handEvaluator = new HandEvaluator();

        for (int i = 0; i < numberOfHands; i++) {
            handEvaluator.evaluateHand(deck.dealHand(numberOfCards));
        }
    }
}
