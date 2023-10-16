package org.poker.resource;

import org.poker.model.IDeckImpl;
import org.poker.service.HandEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "/{value}", produces = "application/json")
    public ResponseEntity<ResponseData> getHand(@PathVariable("value") final int value) {
        return ResponseEntity.ok(
                new ResponseData(
                        this.handEvaluator.evaluateHand(
                                this.deck.dealHand(value)
                        )
                )
        );
    }
}
