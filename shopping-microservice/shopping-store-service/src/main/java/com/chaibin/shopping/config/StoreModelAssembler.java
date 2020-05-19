package com.chaibin.shopping.config;

import com.chaibin.shopping.controllers.StoreController;
import com.chaibin.shopping.core.store.DeliveryAddedCostDto;
import com.chaibin.shopping.core.store.DeliveryCostDto;
import com.chaibin.shopping.core.store.StoreResponseDto;
import com.chaibin.shopping.models.DeliveryAddedCost;
import com.chaibin.shopping.models.DeliveryCost;
import com.chaibin.shopping.models.Store;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class StoreModelAssembler extends RepresentationModelAssemblerSupport<Store, StoreResponseDto> {

    public StoreModelAssembler() {
        super(StoreController.class, StoreResponseDto.class);
    }

    @Override
    public StoreResponseDto toModel(Store entity) {

        return toStoreResponseDto(entity).add(linkTo(methodOn(StoreController.class).getStore(entity.getId())).withSelfRel());
    }

    private StoreResponseDto toStoreResponseDto(Store store) {

        return StoreResponseDto.builder()
                .name(store.getName())
                .brandName(store.getBrandName())
                .category1(store.getCategory1())
                .category2(store.getCategory2())
                .category3(store.getCategory3())
                .content(store.getContent())
                .deliveryAddedCosts(toDeliveryAddedCostDto(store.getDeliveryAddedCosts()))
                .deliveryCosts(toDeliveryCostDto(store.getDeliveryCosts()))
                .description(store.getDescription())
                .build();
    }

    private List<DeliveryAddedCostDto> toDeliveryAddedCostDto(List<DeliveryAddedCost> deliveryAddedCostList) {
        if (deliveryAddedCostList == null) {
            return null;
        }
        return deliveryAddedCostList.stream()
                .map((deliveryAddedCost -> new DeliveryAddedCostDto(deliveryAddedCost.getRegion(), deliveryAddedCost.getCost())))
                .collect(Collectors.toList());
    }

    private List<DeliveryCostDto> toDeliveryCostDto(List<DeliveryCost> deliveryCostList) {
        if (deliveryCostList == null) {
            return null;
        }
        return deliveryCostList.stream()
                .map((deliveryCost -> new DeliveryCostDto(deliveryCost.getCount(), deliveryCost.getCost())))
                .collect(Collectors.toList());
    }
}
