package com.shopingList.demo.service;

import com.shopingList.demo.model.entity.ProductEntity;
import com.shopingList.demo.model.service.ProductServiceModel;
import com.shopingList.demo.model.shopEnum.CategoryEnum;
import com.shopingList.demo.model.view.ProductViewModel;
import com.shopingList.demo.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryServiceImpl categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryServiceImpl categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    public void addProduct(ProductServiceModel productServiceModel) {

        ProductEntity product = modelMapper.map(productServiceModel, ProductEntity.class);
        product.setCategory(categoryService.findByNamee(productServiceModel.getCategory()));
        productRepository.save(product);
    }

    public List <ProductViewModel> productViewModels (CategoryEnum category){
        return productRepository.findByCategory_Name(category).stream().map(a -> modelMapper.map(a, ProductViewModel.class)).collect(Collectors.toList());
    }

    public BigDecimal getTotalPrice (){
        return productRepository.calcTotalPrice();
    }

    public void buyByID(Long id) {
        productRepository.deleteById(id);
    }


    public void buyAll() {
        productRepository.deleteAll();
    }
}

