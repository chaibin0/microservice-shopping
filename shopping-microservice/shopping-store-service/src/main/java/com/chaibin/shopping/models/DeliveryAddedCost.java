package com.chaibin.shopping.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DeliveryAddedCost {

    String region;
    int cost;

    public DeliveryAddedCost(String region, int cost) {
        this.region = region;
        this.cost = cost;
    }
}
