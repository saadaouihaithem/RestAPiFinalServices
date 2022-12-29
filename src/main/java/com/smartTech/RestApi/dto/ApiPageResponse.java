package com.smartTech.RestApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.ArrayList;




@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiPageResponse {


    public int status;
    public ArrayList<Page> pages;
    public String message;
}
