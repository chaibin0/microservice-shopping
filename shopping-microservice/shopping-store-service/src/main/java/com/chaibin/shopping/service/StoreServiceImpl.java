package com.chaibin.shopping.service;

import com.chaibin.shopping.config.StoreModelAssembler;
import com.chaibin.shopping.core.store.*;
import com.chaibin.shopping.exceptions.StoreNotFoundException;
import com.chaibin.shopping.models.*;
import com.chaibin.shopping.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService {

    private StoreRepository storeRepository;

    private StoreModelAssembler storeModelAssembler;

    public StoreServiceImpl(StoreRepository storeRepository, StoreModelAssembler storeModelAssembler) {
        this.storeRepository = storeRepository;
        this.storeModelAssembler = storeModelAssembler;
    }

    @Override
    public Store registerStore(StoreRequestDto dto) {

        Store store = Store.builder()
                .name(dto.getName())
                .brandName(dto.getBrandName())
                .description(dto.getDescription())
                .category1(dto.getCategory1())
                .category2(dto.getCategory2())
                .category3(dto.getCategory3())
                .deliveryAddedCosts(toDeliveryAddedCost(dto.getDeliveryAddedCosts()))
                .deliveryCosts(toDeliveryCost(dto.getDeliveryCosts()))
                .products(toProduct(dto.getProducts()))
                .content(dto.getContent())
                .build();

        return storeRepository.save(store);
    }

    @Override
    public StoreResponseDto getStore(String id) {
        return storeModelAssembler.toModel(storeRepository.findById(id).orElseThrow(StoreNotFoundException::new));
    }

    @Override
    public void deleteStore(String id) {
        Store store = storeRepository.findById(id).orElseThrow(StoreNotFoundException::new);
        store.delete();
        storeRepository.save(store);
    }

    private List<DeliveryCost> toDeliveryCost(List<DeliveryCostDto> deliveryCosts) {

        if (deliveryCosts == null) {
            return null;
        }

        return deliveryCosts.stream()
                .map((deliveryCostDto -> new DeliveryCost(deliveryCostDto.getCount(), deliveryCostDto.getCost())))
                .collect(Collectors.toList());
    }

    private List<DeliveryAddedCost> toDeliveryAddedCost(List<DeliveryAddedCostDto> deliveryAddedCosts) {
        if (deliveryAddedCosts == null) {
            return null;
        }
        return deliveryAddedCosts.stream()
                .map(deliveryAddedCostDto -> new DeliveryAddedCost(deliveryAddedCostDto.getRegion(), deliveryAddedCostDto.getCost()))
                .collect(Collectors.toList());
    }

    private List<Product> toProduct(List<ProductRequestDto> productRequestDtoList) {
        if (productRequestDtoList == null) {
            return null;
        }
        return productRequestDtoList.stream().map((productRequestDto) ->
                Product.builder()
                        .name(productRequestDto.getName())
                        .description(productRequestDto.getDescription())
                        .content(productRequestDto.getContent())
                        .category1(productRequestDto.getCategory1())
                        .category2(productRequestDto.getCategory2())
                        .productStates(toProductState(productRequestDto.getProductStates()))
                        .build()
        ).collect(Collectors.toList());
    }

    private List<ProductState> toProductState(List<ProductStateDto> productStateDtoList) {
        if (productStateDtoList == null) {
            return null;
        }
        return productStateDtoList.stream().map((productStateDto) ->
                ProductState.builder()
                        .name(productStateDto.getName())
                        .cost(productStateDto.getCost())
                        .remain(productStateDto.getRemain())
                        .build()
        ).collect(Collectors.toList());
    }
}
