package com.smartTech.RestApi.Repository;

import com.smartTech.RestApi.Model.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<ServiceCategory, Integer> {
}
