package com.chaibin.shopping.controllers;

import com.chaibin.shopping.common.StaticStore;
import com.chaibin.shopping.config.RestDocsConfig;
import com.chaibin.shopping.core.store.StoreRequestDto;
import com.chaibin.shopping.core.store.StoreResponseDto;
import com.chaibin.shopping.models.Store;
import com.chaibin.shopping.service.StoreService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.document;
import static org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebFluxTest(controllers = StoreController.class)
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
class StoreControllerTest {

    WebTestClient webTestClient;

    String version;

    @MockBean
    StoreService storeService;

    @Autowired
    private ApplicationContext context;

    @BeforeEach
    public void setUp(ApplicationContext applicationContext,
                      RestDocumentationContextProvider restDocumentation) {
        this.webTestClient = WebTestClient.bindToApplicationContext(applicationContext)
                .configureClient()
                .filter(documentationConfiguration(restDocumentation))
                .build();
    }

    @Test
    @DisplayName("상점 등록 테스트")
    void registerStore() throws Exception {

        StoreRequestDto storeRequestDto = StaticStore.STORE_REQUEST_DTO1;
        Store store = StaticStore.STORE1;
        given(storeService.registerStore(any())).willReturn(store);
        webTestClient.post().uri("/v1/stores")
                .body(Mono.just(storeRequestDto), StoreRequestDto.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .consumeWith(
                        document("store-register", requestFields(
                                fieldWithPath("name").type("String").description("상점 이름"),
                                fieldWithPath("brandName").type("String").description("상점 브랜드 이름"),
                                fieldWithPath("description").type("String").description("상점 간단 설명"),
                                fieldWithPath("content").type("String").description("상점에서 세부 내용"),
                                fieldWithPath("category1").type("String").description("카테고리1"),
                                fieldWithPath("category2").type("String").description("카테고리2"),
                                fieldWithPath("category3").type("String").description("카테고리2"),
                                subsectionWithPath("products").type("Array").description("상품들").optional(),
                                subsectionWithPath("products[].name").type("String").description("상품 이름"),
                                subsectionWithPath("products[].description").type("String").description("상품 설명"),
                                subsectionWithPath("products[].category1").type("String").description("상품 세부 카테고리1"),
                                subsectionWithPath("products[].category2").type("String").description("상품 세부 카테고리2"),
                                subsectionWithPath("products[].productStates").type("Array").description("상품 세부 내용"),
                                subsectionWithPath("products[].productStates[].name").type("String").description("상품 세부 이름"),
                                subsectionWithPath("products[].productStates[].remain").type("Number").description("상품 남은 갯수"),
                                subsectionWithPath("products[].productStates[].cost").type("Number").description("상품 가격"),
                                subsectionWithPath("deliveryCosts").type("Array").description("택배 추가 요금)").optional(),
                                subsectionWithPath("deliveryCosts[].count").type("count").description("필요 갯수 이상일때").optional(),
                                subsectionWithPath("deliveryCosts[].cost").type("cost").description("추가되는 가격").optional(),
                                subsectionWithPath("deliveryAddedCosts").type("Array").description("산간지역, 제주 등의 추가 요금").optional(),
                                subsectionWithPath("deliveryAddedCosts[].region").type("Array").description("지역").optional(),
                                subsectionWithPath("deliveryAddedCosts[].cost").type("Array").description("지역에서 추가되는 요금").optional()
                        ), responseHeaders(
                                headerWithName("Location").description("만들어진 상점 URI주소")))).returnResult();

    }

    @Test
    @DisplayName("상점 조회 테스트")
    void getStoreTest() {
        StoreResponseDto responseDto = StaticStore.STORE_RESPONSE_DTO1
                .add(linkTo(methodOn(StoreController.class).getStore("abc")).withSelfRel());
        given(storeService.getStore(any())).willReturn(responseDto);

        //products, deliveryCosts, deliveryAddedCosts 검사할것
        webTestClient.get().uri("/v1/stores/" + "abc")
                .accept(MediaTypes.HAL_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.name").isEqualTo(responseDto.getName())
                .jsonPath("$.brandName").isEqualTo(responseDto.getBrandName())
                .jsonPath("$.description").isEqualTo(responseDto.getDescription())
                .jsonPath("$.content").isEqualTo(responseDto.getContent())
                .jsonPath("$.category1").isEqualTo(responseDto.getCategory1())
                .jsonPath("$.category2").isEqualTo(responseDto.getCategory2())
                .jsonPath("$.category3").isEqualTo(responseDto.getCategory3())
                .consumeWith(
                        document("store-get", responseFields(
                                fieldWithPath("name").type("String").description("상점 이름"),
                                fieldWithPath("brandName").type("String").description("상점 브랜드 이름"),
                                fieldWithPath("description").type("String").description("상점 간단 설명"),
                                fieldWithPath("content").type("String").description("상점에서 세부 내용"),
                                fieldWithPath("category1").type("String").description("카테고리1"),
                                fieldWithPath("category2").type("String").description("카테고리2"),
                                fieldWithPath("category3").type("String").description("카테고리2"),
                                subsectionWithPath("products").type("Array").description("상품들").optional(),
                                subsectionWithPath("products[].name").type("String").description("상품 이름"),
                                subsectionWithPath("products[].description").type("String").description("상품 설명"),
                                subsectionWithPath("products[].category1").type("String").description("상품 세부 카테고리1"),
                                subsectionWithPath("products[].category2").type("String").description("상품 세부 카테고리2"),
                                subsectionWithPath("products[].productStates").type("Array").description("상품 세부 내용"),
                                subsectionWithPath("products[].productStates[].name").type("String").description("상품 세부 이름"),
                                subsectionWithPath("products[].productStates[].remain").type("Number").description("상품 남은 갯수"),
                                subsectionWithPath("products[].productStates[].cost").type("Number").description("상품 가격"),
                                subsectionWithPath("deliveryCosts").type("Array").description("택배 추가 요금)").optional(),
                                subsectionWithPath("deliveryCosts[].count").type("count").description("필요 갯수 이상일때").optional(),
                                subsectionWithPath("deliveryCosts[].cost").type("cost").description("추가되는 가격").optional(),
                                subsectionWithPath("deliveryAddedCosts").type("Array").description("산간지역, 제주 등의 추가 요금").optional(),
                                subsectionWithPath("deliveryAddedCosts[].region").type("Array").description("지역").optional(),
                                subsectionWithPath("deliveryAddedCosts[].cost").type("Array").description("지역에서 추가되는 요금").optional(),
                                subsectionWithPath("links").type("Array").description("link")
                        )));
    }

    @Test
    @DisplayName("상점 삭제 테스트")
    void deleteStore() {

        Mockito.doNothing().when(storeService).deleteStore(any());
        webTestClient.delete()
                .uri("/v1/stores/" + "abc")
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .consumeWith(document("store-delete"));
    }
}