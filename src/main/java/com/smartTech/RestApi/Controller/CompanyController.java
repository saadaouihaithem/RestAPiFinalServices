package com.smartTech.RestApi.Controller;

import com.smartTech.RestApi.Model.Conpany;
import com.smartTech.RestApi.Repository.AgencyRepository;
import com.smartTech.RestApi.Service.AgencyService;
import com.smartTech.RestApi.dto.ApiResponseAgeincies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/v1")
public class CompanyController {





    @Autowired
    private AgencyService agencyService;
    @Autowired
    private AgencyRepository agencyRepository;





    @PostMapping("/Company")
    public ResponseEntity<Conpany> SaveAgency(@RequestBody Conpany agency) {

        return new ResponseEntity<Conpany>(agencyService.saveAgency(agency), HttpStatus.CREATED);
    }







    @GetMapping("/Company")
    public ApiResponseAgeincies<List<Conpany>> getAgencies() {
        List<Conpany>allAgency=agencyService.findViewsWithSortingAsc();

        return new  ApiResponseAgeincies<>(allAgency.size(),allAgency);
    }




}
