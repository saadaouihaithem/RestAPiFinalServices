package com.smartTech.RestApi.Service;

import com.smartTech.RestApi.Model.ServiceCategory;
import com.smartTech.RestApi.Model.Services;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

        public ServiceCategory addCategory(ServiceCategory serviceCategory);
        public String deleteCategory(int category_id );
        public ServiceCategory editCategory(int category_id , ServiceCategory serviceCategory);
        public List<ServiceCategory> getAllCats();
        public Optional<ServiceCategory> getOneCat(int category_id );
        public boolean isExistById(int category_id);
}
