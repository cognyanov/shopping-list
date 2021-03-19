package com.shopingList.demo.web;

import com.shopingList.demo.model.shopEnum.CategoryEnum;
import com.shopingList.demo.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexPageController {
    private final ProductServiceImpl productService;

    public IndexPageController(ProductServiceImpl productService) {
        this.productService = productService;
    }


    @GetMapping ("/")
    public String getIndexPage (HttpSession httpSession, Model model){

        if  (httpSession.getAttribute("user") == null){
            return "index";
        }
        model.addAttribute("food", productService.productViewModels(CategoryEnum.Food));
        model.addAttribute("drink", productService.productViewModels(CategoryEnum.Drink));
        model.addAttribute("houseHold", productService.productViewModels(CategoryEnum.Household));
        model.addAttribute("other", productService.productViewModels(CategoryEnum.Other));

        model.addAttribute("sum", productService.getTotalPrice());



        return "home";
    }


}
