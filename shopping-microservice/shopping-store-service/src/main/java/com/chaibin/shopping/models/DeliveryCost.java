package com.chaibin.shopping.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DeliveryCost {

    int count;
    int cost;

    public DeliveryCost(int count, int cost) {
        this.count = count;
        this.cost = cost;
    }
}
