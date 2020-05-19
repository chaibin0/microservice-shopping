package com.chaibin.shopping.common;

import com.chaibin.shopping.core.store.ProductRequestDto;
import com.chaibin.shopping.core.store.ProductStateDto;
import com.chaibin.shopping.core.store.StoreRequestDto;
import com.chaibin.shopping.core.store.StoreResponseDto;
import com.chaibin.shopping.models.Product;
import com.chaibin.shopping.models.ProductState;
import com.chaibin.shopping.models.Store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface StaticStore {

    ProductStateDto PRODUCT_STATE_DTO1 = ProductStateDto.builder()
            .name("clothes red")
            .cost(10000)
            .remain(30)
            .build();

    List<ProductStateDto> PRODUCT_STATE_LIST1 = new ArrayList<>(Arrays.asList(PRODUCT_STATE_DTO1));

    ProductRequestDto PRODUCT_REQUEST_DTO1 = ProductRequestDto.builder()
            .name("product1")
            .description("product1 description")
            .content("product content")
            .category1("product category1")
            .category2("product category2")
            .productStates(PRODUCT_STATE_LIST1)
            .build();

    List<ProductRequestDto> PRODUCT_REQUEST_DTO_LIST1 = new ArrayList<>(Arrays.asList(PRODUCT_REQUEST_DTO1));

    StoreRequestDto STORE_REQUEST_DTO1 = StoreRequestDto.builder()
            .name("storeName")
            .description("store description")
            .brandName("brand")
            .category1("category1")
            .category2("category2")
            .category3("category3")
            .content("store content")
            .products(PRODUCT_REQUEST_DTO_LIST1)
            .build();


    ProductState productState1 = ProductState.builder()
            .name("clothes red")
            .cost(10000)
            .remain(30)
            .build();

    List<ProductState> productStateList1 = new ArrayList<>(Arrays.asList(productState1));

    Product PRODUCT1 = Product.builder()
            .name("product1")
            .description("product1 description")
            .content("product content")
            .category1("product category1")
            .category2("product category2")
            .productStates(productStateList1)
            .build();

    List<Product> productList = new ArrayList<>(Arrays.asList(PRODUCT1));

    Store STORE1 = Store.builder()
            .name("storeName")
            .description("store description")
            .brandName("brand")
            .category1("category1")
            .category2("category2")
            .category3("category3")
            .content("store content")
            .products(productList)
            .build();

    StoreResponseDto STORE_RESPONSE_DTO1 = StoreResponseDto.builder()
            .name("storeName")
            .description("store description")
            .brandName("brand")
            .category1("category1")
            .category2("category2")
            .category3("category3")
            .content("store content")
            .build();

}
