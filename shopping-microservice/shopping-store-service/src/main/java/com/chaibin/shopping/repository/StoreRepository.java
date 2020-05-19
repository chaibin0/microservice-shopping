package com.chaibin.shopping.repository;


import com.chaibin.shopping.models.Store;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends MongoRepository<Store, String> {

    Store findByName(String storeName);
}
