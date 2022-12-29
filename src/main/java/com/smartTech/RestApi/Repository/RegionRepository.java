package com.smartTech.RestApi.Repository;

import com.smartTech.RestApi.Model.Region;
import com.smartTech.RestApi.Model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region,Long> {
    @Query("FROM Region ORDER BY region_id ASC")
    List<Region> findAllOrderByPopulationAsc();


}


