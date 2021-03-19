package com.shopingList.demo.web;

import com.shopingList.demo.binding.ProductBindingModel;
import com.shopingList.demo.model.service.ProductServiceModel;
import com.shopingList.demo.service.ProductServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping ("/product")
public class ProductPageController {

    private final ProductServiceImpl productService;
    private final ModelMapper modelMapper;


    public ProductPageController(ProductServiceImpl productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addProductForm (HttpSession httpSession, Model model){
        if (!model.containsAttribute("productBindingModel")) {
            model.addAttribute("productBindingModel", new ProductBindingModel());
        }
        if (httpSession.getAttribute("user") == null){
            return "redirect:/users/login";
        }

        return  "product-add";
    }

    @PostMapping ("/add")
    public String addProducts (@Valid ProductBindingModel productBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("productBindingModel", productBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productBindingModel",bindingResult);
            return "redirect:add";
        }

        productService.addProduct(modelMapper.map(productBindingModel, ProductServiceModel.class));


        return "redirect:/";
    }

    @GetMapping ("/buy/{id}")
    public String buyByID(@PathVariable Long id) {
        productService.buyByID(id);
        return "redirect:/";
    }

    @GetMapping("/buy/all")
    public String buyAll() {

        productService.buyAll();

        return "redirect:/";
    }
}
