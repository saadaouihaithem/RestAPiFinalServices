package com.smartTech.RestApi.Service;

import com.smartTech.RestApi.Model.Reviews;
import com.smartTech.RestApi.Model.Services;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServicesServices {

    Services getSingleService(Long id );
    List<Services> getServices();
    Services saveServices(Services services);

    void deleteService(Long id );

    Services updateService(Services services );
    List <Services> getServicesTitle(String title);

    List<Services> getServicesByTitleAndLocation(String address);

    List <Services>getServicesByPrice(int price );


    List <Services>getServicesBySlug(String slug);


    List <Services>getServicesByDescription(String description);

    List <Services>getServicesByCategory(int category_id);


    List <Services>getServicesByRegion_id(String region_id);

    void deleteService(String description);


    public boolean isExistById(long id);

       List<Services> findViewsWithSortingAsc();

        Services addReviewToServices(long id, Reviews review);

       List<Reviews>getAllReviewsForServices(long id);

      List <Services> getAllServicesWithPagingAndSorting(Pageable pageable);

      Reviews approvedReview(long id , long review_id, String approved );

      List<Services>getAllServicesWithCat(Pageable pageable , int category_id  );

      List <Reviews> getAllReviewsWithoutApproval();







}
