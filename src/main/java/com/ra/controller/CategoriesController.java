package com.ra.controller;

import com.ra.model.Categories;
import com.ra.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/categoriesController")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;
    @GetMapping(value = "/findAll")
    public ModelAndView getAllCatalog(){
        ModelAndView mav = new ModelAndView("categories");
        List<Categories> listCatalog = categoriesService.findAll();
        mav.addObject("listCatalog",listCatalog);
        return mav;
    }
}
