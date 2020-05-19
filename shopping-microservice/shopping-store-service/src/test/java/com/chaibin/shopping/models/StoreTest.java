package com.chaibin.shopping.models;

import com.chaibin.shopping.common.StaticStore;
import com.chaibin.shopping.repository.StoreRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


@DataMongoTest
class StoreTest {

    @Autowired
    StoreRepository storeRepository;

    @Test
    @DisplayName("가게 생성 테스트")
    void registerStoreTest() {

        Store store = StaticStore.STORE1;
        Store savedStore = storeRepository.save(store);
        assertAll(
                () -> assertThat(savedStore.getName()).isEqualTo(store.getName()),
                () -> assertThat(savedStore.getDescription()).isEqualTo(store.getDescription())
        );
        System.out.println(savedStore.getId());
    }


    @Test
    @DisplayName("가게 탐색 테스트")
    void getStoreTest() {
        Store store = StaticStore.STORE1;
        Store savedStore = storeRepository.save(store);
        Store getStore = storeRepository.findByName(savedStore.getName());

        assertAll(
                () -> assertThat(getStore.getName()).isEqualTo(store.getName()),
                () -> assertThat(getStore.getDescription()).isEqualTo(store.getDescription())
        );
    }
}