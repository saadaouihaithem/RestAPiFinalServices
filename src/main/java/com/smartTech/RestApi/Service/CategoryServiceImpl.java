package com.smartTech.RestApi.Service;

import com.smartTech.RestApi.Model.ServiceCategory;
import com.smartTech.RestApi.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public ServiceCategory addCategory(ServiceCategory serviceCategory) {
        try {
            return categoryRepository.save(serviceCategory);
        } catch (IllegalArgumentException e) {
            System.out.println("ADD CATEGORY ERROR: " + e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteCategory(int category_id ) {
        try {
            categoryRepository.deleteById(category_id);
            return "DELETE CATEGORY DONE";
        } catch (IllegalArgumentException e) {
            System.out.println("DELETE CATEGORY ERROR: " + e.getMessage());
            return "DELETE CATEGORY ERROR: " + e.getMessage();
        }
    }

    @Override
    public ServiceCategory editCategory(int category_id , ServiceCategory serviceCategory) {

        try {
            if (categoryRepository.existsById( category_id )) {
                ServiceCategory oldOne = categoryRepository.findById(category_id).get();
                if (serviceCategory.getName() != null)
                    oldOne.setName(serviceCategory.getName());
                return oldOne;
            } else return null;
        } catch (IllegalArgumentException e) {
            System.out.println("EDIT CATEGORY ERROR: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<ServiceCategory> getAllCats() {
        try {
            return (List<ServiceCategory>)categoryRepository.findAll();
        }catch (IllegalArgumentException e){
            System.out.println("GET ALL CATS ERROR: "+e.getMessage());
            return null;
        }
    }

    @Override
    public Optional<ServiceCategory> getOneCat(int category_id) {
        return categoryRepository.findById( category_id );
    }

    @Override
    public boolean isExistById(int category_id) {
        return categoryRepository.existsById(category_id);
    }}