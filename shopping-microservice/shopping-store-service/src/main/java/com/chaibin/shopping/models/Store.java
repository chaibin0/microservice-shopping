package com.chaibin.shopping.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "store")
@Getter
@NoArgsConstructor
public class Store extends BasedEntity {

    @Id
    String id;

    private String userId;

    private String slug;

    private String name;

    private String brandName;

    private String description;

    private String content;

    private String category1;

    private String category2;

    private String category3;

    private List<Product> products;

    private List<DeliveryCost> deliveryCosts;

    private List<DeliveryAddedCost> deliveryAddedCosts;

    private boolean deleted;

    private LocalDateTime deletedAt;

    @Builder
    public Store(String name, String brandName, String description, String content, String category1,
                 String category2, String category3, List<Product> products, List<DeliveryCost> deliveryCosts, List<DeliveryAddedCost> deliveryAddedCosts) {
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
        this.deleted = false;
    }

    public void delete() {
        this.deleted = true;
        deletedAt = LocalDateTime.now();
    }
}
