package com.smartTech.RestApi.Service;

import com.smartTech.RestApi.Model.Region;
import com.smartTech.RestApi.Model.Services;
import com.smartTech.RestApi.Repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RegionServiceImpl implements RegionService{




  @Autowired
  private RegionRepository regionRepository;

    @Autowired
    private RegionService regionService;




    @Override
    public Region saveRegion(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public List<Region> getRegion() {
        return regionRepository.findAll();
    }

    @Override
    public List<Region> findViewsWithSortingAsc() {
        return regionRepository.findAllOrderByPopulationAsc();
    }




    public List<Region>findRegionsWithPaginationAndSorting(String field) {
        return regionRepository.findAll(Sort.by(Sort.Direction.ASC, field));

    }
    public Page<Region> findRegionsWithPagination(int offset, int pageSize){
        Page<Region>regionPage=regionRepository.findAll(PageRequest.of(offset,pageSize));

        return regionPage;
    }

    public Page<Region>findRegionsWithPaginationSorting(int offset,int pageSize,String field){

        Page<Region>regionPage=regionRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by(field)));
        return regionPage;
    }




}
