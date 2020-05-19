package com.chaibin.shopping.core.store;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Getter
@NoArgsConstructor
public class StoreResponseDto extends RepresentationModel<StoreResponseDto> {

    @JsonProperty("name")
    private String name;

    @JsonProperty("brandName")
    private String brandName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("content")
    private String content;

    @JsonProperty("category1")
    private String category1;

    @JsonProperty("category2")
    private String category2;

    @JsonProperty("category3")
    private String category3;

    @JsonProperty("products")
    private List<ProductRequestDto> products;

    @JsonProperty("deliveryCosts")
    private List<DeliveryCostDto> deliveryCosts;

    @JsonProperty("deliveryAddedCosts")
    private List<DeliveryAddedCostDto> deliveryAddedCosts;

    @Builder
    public StoreResponseDto(String name, String brandName, String description, String content, String category1, String category2, String category3, List<ProductRequestDto> products, List<DeliveryCostDto> deliveryCosts, List<DeliveryAddedCostDto> deliveryAddedCosts) {
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
