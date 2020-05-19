package com.chaibin.shopping.models;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductState {

    String name;

    int remain;

    int cost;

    @Builder
    public ProductState(String name, int remain, int cost) {
        this.name = name;
        this.remain = remain;
        this.cost = cost;
    }
}
