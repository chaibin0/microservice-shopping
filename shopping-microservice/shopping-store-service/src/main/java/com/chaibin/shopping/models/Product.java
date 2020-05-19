package com.chaibin.shopping.models;

import com.chaibin.shopping.core.store.ProductRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@Document("product")
public class Product extends BasedEntity {

    @Id
    String id;

    String slug;

    String name;

    String description;

    String content;

    String category1;

    String category2;

    List<ProductState> productStates;

    public void addProductState(ProductState productState) {
        productStates.add(productState);
    }

    @Builder
    public Product(String name, String description, String content, String category1, String category2, List<ProductState> productStates) {
        this.name = name;
        this.description = description;
        this.content = content;
        this.category1 = category1;
        this.category2 = category2;
        this.productStates = productStates;
    }
}
