package com.smartTech.RestApi.Model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseAllServices extends Response{

    private List<Services> services;
}