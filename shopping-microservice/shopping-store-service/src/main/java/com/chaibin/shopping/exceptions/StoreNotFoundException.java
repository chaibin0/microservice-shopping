package com.chaibin.shopping.exceptions;

public class StoreNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "해당하는 상점이 없습니다.";
    }
}
