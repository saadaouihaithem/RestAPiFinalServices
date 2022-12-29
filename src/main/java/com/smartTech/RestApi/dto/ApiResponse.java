package com.smartTech.RestApi.dto;

import com.smartTech.RestApi.Model.Region;
import com.smartTech.RestApi.Model.Services;
import com.smartTech.RestApi.util.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse <T>   {

        public int Totale;

         T Services;


    }

