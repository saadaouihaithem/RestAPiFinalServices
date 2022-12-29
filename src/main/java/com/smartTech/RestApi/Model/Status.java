package com.smartTech.RestApi.Model;


public enum Status {
    APPROVED("Approved"),
    PENDING("Pending");



    private String serviceStatus;

    Status(String status){this.serviceStatus=status;}

    public String getServiceStatus(){
        return this.serviceStatus;
    }
}