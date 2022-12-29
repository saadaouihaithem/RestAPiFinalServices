package com.smartTech.RestApi.Repository;

import com.smartTech.RestApi.Model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
