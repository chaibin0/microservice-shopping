package com.chaibin.shopping.core.store;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ProductRequestDto {

    @JsonProperty("name")
    String name;

    @JsonProperty("description")
    String description;

    @JsonProperty("content")
    String content;

    @JsonProperty("category1")
    String category1;

    @JsonProperty("category2")
    String category2;

    @JsonProperty("productStates")
    List<ProductStateDto> productStates;

    @Builder
    public ProductRequestDto(String name, String description, String content, String category1, String category2, List<ProductStateDto> productStates) {
        this.name = name;
        this.description = description;
        this.content = content;
        this.category1 = category1;
        this.category2 = category2;
        this.productStates = productStates;
    }
}
