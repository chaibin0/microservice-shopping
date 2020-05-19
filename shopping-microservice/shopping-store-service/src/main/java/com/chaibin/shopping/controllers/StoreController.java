package com.chaibin.shopping.controllers;

import com.chaibin.shopping.core.store.StoreRequestDto;
import com.chaibin.shopping.core.store.StoreResponseDto;
import com.chaibin.shopping.models.Store;
import com.chaibin.shopping.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("v1/stores")
public class StoreController {

    private StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<StoreResponseDto>> getStore(@PathVariable("id") String id) {

        return Mono.just(ResponseEntity.ok(storeService.getStore(id)));
    }

    @PostMapping("")
    public Mono<ResponseEntity<Void>> registerStore(@RequestBody StoreRequestDto request) {

        Store store = storeService.registerStore(request);
        return Mono.just(ResponseEntity.created(linkTo(methodOn(this.getClass()).getStore(store.getId())).toUri())
                .body(null));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteStore(@PathVariable("id") String id) {

        storeService.deleteStore(id);
        return Mono.just(ResponseEntity.accepted().body(null));
    }


}
