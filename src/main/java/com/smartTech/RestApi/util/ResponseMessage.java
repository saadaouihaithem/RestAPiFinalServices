package com.smartTech.RestApi.util;

public enum ResponseMessage {

    SUCCESS("success creation"),
    SUCCESS_GET("success"),
    MODIFIED("success modification"),
    SUCCESS_LOGIN("success login"),
    NO_CONTENT("Sent infotmation is empty"),
    ERROR("Unexpected error"),
    FORBIDDEN("Not allowed"),
    WRONG_CREDENTIALS("Wrong credentials"),
    FOUND("The user is already registered"),
    SERVICES_NOT_FOUND("The order is not created"),
    ORDER_ITEM_NOT_FOUND("The order does not have items"),
    SUCCESS_UPDATE("success update");

    private String message;

    ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
