package com.smartTech.RestApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse <T>   {

    public int status;

         T Services;
    }

