package com.chaibin.shopping.core.store;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeliveryAddedCostDto {

    @JsonProperty("region")
    String region;

    @JsonProperty("cost")
    int cost;

    public DeliveryAddedCostDto(String region, int cost) {
        this.region = region;
        this.cost = cost;
    }
}
