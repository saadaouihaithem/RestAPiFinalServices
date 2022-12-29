package com.smartTech.RestApi.Controller;

import com.smartTech.RestApi.Model.Region;
import com.smartTech.RestApi.Model.Services;
import com.smartTech.RestApi.Repository.RegionRepository;
import com.smartTech.RestApi.Service.RegionServiceImpl;
import com.smartTech.RestApi.dto.ApiRegionResponse;
import com.smartTech.RestApi.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class RegionController {

    @Autowired
    private RegionServiceImpl regionService;
    @Autowired
    private RegionRepository regionRepository;





    @PostMapping("/Regions")
    public ResponseEntity<Region> SaveRegion(@RequestBody Region region) {

        return new ResponseEntity<Region>(regionService.saveRegion(region), HttpStatus.CREATED);
    }

    @GetMapping("/AlltheRegions")
    public ApiRegionResponse<List<Region>> AlltheRegions() {
        List<Region>allRegions=regionService.findViewsWithSortingAsc();

        return new  ApiRegionResponse<>(allRegions.size(),allRegions);
    }


}

