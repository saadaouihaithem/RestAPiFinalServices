package com.smartTech.RestApi.Controller;

import com.smartTech.RestApi.Model.ServiceCategory;
import com.smartTech.RestApi.Service.CategoryService;
import com.smartTech.RestApi.Service.ServicesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ServicesServices servicesServices;

    @GetMapping()
    public List<ServiceCategory> getAllCats(){
        return categoryService.getAllCats();
    }
    @GetMapping("{cat_id}")
    public ServiceCategory getOneCat(@PathVariable int  category_id ){
        return categoryService.getOneCat(category_id).orElse(null);
    }
}
