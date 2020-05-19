package com.chaibin.shopping.core.store;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeliveryCostDto {

    @JsonProperty("count")
    int count;

    @JsonProperty("cost")
    int cost;

    public DeliveryCostDto(int count, int cost) {
        this.count = count;
        this.cost = cost;
    }
}
