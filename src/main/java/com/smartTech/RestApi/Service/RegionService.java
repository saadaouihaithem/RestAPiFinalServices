package com.smartTech.RestApi.Service;

import com.smartTech.RestApi.Model.Region;

import java.util.List;

public interface RegionService {

   Region saveRegion(Region region);

    List<Region> getRegion();

    List<Region> findViewsWithSortingAsc();



}


