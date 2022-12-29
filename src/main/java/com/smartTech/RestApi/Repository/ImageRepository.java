package com.smartTech.RestApi.Repository;

import com.smartTech.RestApi.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
    Optional<Image> findByName(String name);

}
