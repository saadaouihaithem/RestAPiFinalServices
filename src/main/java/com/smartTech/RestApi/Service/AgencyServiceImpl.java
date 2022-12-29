package com.smartTech.RestApi.Service;

import com.smartTech.RestApi.Model.Conpany;

import com.smartTech.RestApi.Repository.AgencyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AgencyServiceImpl implements AgencyService{


    @Autowired
    private AgencyRepository agencyRepository;




    @Override
    public Conpany getSingleAgency(Long id) {


        Optional<Conpany> agency=agencyRepository.findById(id);

        if(agency.isPresent()){
            return agency.get();
        }
        throw new RuntimeException("Agency not available");
    }



    @Override
    public List<Conpany> getAgencies() {
        return agencyRepository.findAll();
    }

    @Override
    public Conpany saveAgency(Conpany agency) {
        return agencyRepository.save(agency);
    }





    @Override
    public List<Conpany> findViewsWithSortingAsc() {

        return agencyRepository.findAll();

    }

    public List<Conpany> findServicesWithPaginationAndSorting(String field) {
        return agencyRepository.findAll(Sort.by(Sort.Direction.ASC, field));

    }
    public Page<Conpany> findServicesWithPagination(int offset, int pageSize){
        Page<Conpany> service=agencyRepository.findAll(PageRequest.of(offset,pageSize));

        return service;
    }

    public Page<Conpany> findServicesWithPaginationSorting(int offset, int pageSize, String field){

        Page<Conpany> service=agencyRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by(field)));
        return service;
    }


}
