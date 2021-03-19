package com.shopingList.demo.service;

import com.shopingList.demo.model.entity.CategoryEntity;
import com.shopingList.demo.model.shopEnum.CategoryEnum;
import com.shopingList.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {


        if (categoryRepository.count() == 0) {
            CategoryEntity food = new CategoryEntity();
            food.setName(CategoryEnum.Food);
            food.setDescription("This is food, you can eat this.");
            categoryRepository.save(food);

            CategoryEntity drink = new CategoryEntity();
            drink.setName(CategoryEnum.Drink);
            drink.setDescription("This is drink, you can drink this.");
            categoryRepository.save(drink);

            CategoryEntity household = new CategoryEntity();
            household.setName(CategoryEnum.Household);
            household.setDescription("This is household, you can clean with this.");
            categoryRepository.save(household);

            CategoryEntity other = new CategoryEntity();
            other.setName(CategoryEnum.Other);
            other.setDescription("this is other, you can do other things with this. DO NOT EAT OR DRINK");
            categoryRepository.save(other);
        }
    }

    @Override
     public CategoryEntity findByNamee(CategoryEnum category) {
     return categoryRepository.findByName(category).orElse(null);
    }


}
