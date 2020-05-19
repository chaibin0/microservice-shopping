package com.chaibin.shopping.core.store;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@NoArgsConstructor
public class StoreRequestDto {

    @NotEmpty
    @JsonProperty("name")
    private String name;

    @JsonProperty("brandName")
    private String brandName;

    @NotEmpty
    @JsonProperty("description")
    private String description;

    @NotEmpty
    @JsonProperty("content")
    private String content;

    @NotEmpty
    @JsonProperty("category1")
    private String category1;

    @NotEmpty
    @JsonProperty("category2")
    private String category2;

    @NotEmpty
    @JsonProperty("category3")
    private String category3;

    @JsonProperty("products")
    private List<ProductRequestDto> products;

    @JsonProperty("deliveryCosts")
    private List<DeliveryCostDto> deliveryCosts;

    @JsonProperty("deliveryAddedCosts")
    private List<DeliveryAddedCostDto> deliveryAddedCosts;

    @Builder
    public StoreRequestDto(String name, String brandName, String description, String content, String category1, String category2, String category3, List<ProductRequestDto> products, List<DeliveryCostDto> deliveryCosts, List<DeliveryAddedCostDto> deliveryAddedCosts) {
        this.name = name;
        this.brandName = brandName;
        this.description = description;
        this.content = content;
        this.category1 = category1;
        this.category2 = category2;
        this.category3 = category3;
        this.products = products;
        this.deliveryCosts = deliveryCosts;
        this.deliveryAddedCosts = deliveryAddedCosts;
    }
}
