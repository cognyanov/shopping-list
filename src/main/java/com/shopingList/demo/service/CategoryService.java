package com.shopingList.demo.service;


import com.shopingList.demo.model.entity.CategoryEntity;
import com.shopingList.demo.model.shopEnum.CategoryEnum;

import java.util.Optional;

public interface CategoryService {
    void initCategories();
    CategoryEntity findByNamee(CategoryEnum category);
}
