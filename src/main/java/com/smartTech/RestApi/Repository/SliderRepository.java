package com.smartTech.RestApi.Repository;

import com.smartTech.RestApi.Model.Slider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SliderRepository extends JpaRepository<Slider,Long> {


}
