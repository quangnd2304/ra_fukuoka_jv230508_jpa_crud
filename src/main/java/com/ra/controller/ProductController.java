package com.ra.controller;

import com.ra.model.Categories;
import com.ra.model.Product;
import com.ra.service.CategoriesService;
import com.ra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/productController")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoriesService categoriesService;
    @GetMapping(value = "findAll")
    public ModelAndView getAllProduct(){
        ModelAndView mav = new ModelAndView("products");
        List<Product> listProduct = productService.findAll();
        mav.addObject("listProduct",listProduct);
        return mav;
    }
    @GetMapping(value = "/search")
    public ModelAndView searchProductByName(String searchName){
        ModelAndView mav = new ModelAndView("products");
        List<Product> listProduct = productService.findByName(searchName);
        mav.addObject("listProduct",listProduct);
        return mav;
    }
    @GetMapping(value = "/initCreate")
    public String initCreate(ModelMap modelMap){
        Product proNew = new Product();
        //Lấy thông tin tất cả các danh mục
        List<Categories> listCategories = categoriesService.findAll();
        //add thông tin vào modelMap
        modelMap.addAttribute("proNew",proNew);
        modelMap.addAttribute("listCategories",listCategories);
        return "productNew";
    }
    @PostMapping(value = "/create")
    public String createProduct(Product proNew){
        boolean result = productService.save(proNew);
        if (result){
            return "redirect:findAll";
        }else{
            return "error";
        }
    }
}
