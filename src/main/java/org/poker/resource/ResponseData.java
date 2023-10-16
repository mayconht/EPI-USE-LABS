package org.poker.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.poker.model.Hand;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ResponseData(Map<Hand, String> evaluation) {

    public Hand getHand() {
        return this.evaluation.keySet().stream().findFirst().orElse(null);
    }

    public String getHandName() {
        return this.evaluation.values().stream().findFirst().orElse(null);
    }
}
