package com.chaibin.shopping.core.store;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ProductStateDto {

    @JsonProperty("name")
    String name;

    @JsonProperty("remain")
    int remain;

    @JsonProperty("cost")
    int cost;

    @Builder
    public ProductStateDto(String name, int remain, int cost) {
        this.name = name;
        this.remain = remain;
        this.cost = cost;
    }
}
