package com.chaibin.shopping.service;

import com.chaibin.shopping.core.store.StoreRequestDto;
import com.chaibin.shopping.core.store.StoreResponseDto;
import com.chaibin.shopping.models.Store;

public interface StoreService {

    Store registerStore(StoreRequestDto dto);

    StoreResponseDto getStore(String id);

    void deleteStore(String id);
}
