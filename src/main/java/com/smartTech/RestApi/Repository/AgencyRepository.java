package com.smartTech.RestApi.Repository;

import com.smartTech.RestApi.Model.Conpany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<Conpany, Long> {


}
