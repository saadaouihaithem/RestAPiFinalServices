package com.smartTech.RestApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ApiRegionResponse<T>{


        public int status;
        T Region;
    }



