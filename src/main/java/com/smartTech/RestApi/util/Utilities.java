package com.smartTech.RestApi.util;

import com.smartTech.RestApi.Model.Response;
import com.smartTech.RestApi.Model.Services;

public class Utilities {


    public static Response error(String errorMessage) {
        Response response = new Response();
        response.setResponseCode(ResponseCode.ERROR.getResponseCode());
        response.setResponseMessage(errorMessage);
        return response;
    }


    public static Response successCreation() {
        Response response = new Response();
        response.setResponseCode(ResponseCode.SUCCESS.getResponseCode());
        response.setResponseMessage(ResponseMessage.SUCCESS.getMessage());
        return response;
    }

    public static Response ServicesNotCreated() {
        Response response = new Response();
        response.setResponseCode(ResponseCode.NOT_FOUND.getResponseCode());
        response.setResponseMessage(ResponseMessage.SERVICES_NOT_FOUND.getMessage());
        return response;
    }


    public static Response itemNotCreated() {
        Response response = new Response();
        response.setResponseCode(ResponseCode.NOT_FOUND.getResponseCode());
        response.setResponseMessage(ResponseMessage.ORDER_ITEM_NOT_FOUND.getMessage());
        return response;
    }

    public static Services editServices(Services services) {

        return services;
    }


}
