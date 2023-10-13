package org.poker.resource;

import org.poker.model.IDeckImpl;
import org.poker.service.HandEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hand")
public class HandResource {

    @Autowired
    private HandEvaluator handEvaluator;
    @Autowired
    private IDeckImpl deck;

    @GetMapping("/{value}")
    public String getHand(@PathVariable("value") final int value) {
        return this.handEvaluator.evaluateHand(this.deck.dealHand(value)).toString();
    }
}
