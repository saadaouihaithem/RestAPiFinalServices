package com.smartTech.RestApi.Service;

import com.smartTech.RestApi.Model.Conpany;


import java.util.List;

public interface AgencyService {


    Conpany getSingleAgency(Long id );
    List<Conpany> getAgencies();
    Conpany saveAgency(Conpany agency);

    List<Conpany> findViewsWithSortingAsc();
}
