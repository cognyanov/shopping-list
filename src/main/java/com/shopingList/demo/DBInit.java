package com.shopingList.demo;

import com.shopingList.demo.service.CategoryServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

   private final CategoryServiceImpl categoryService;

    public DBInit(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    public void run(String... args) throws Exception {
     categoryService.initCategories();
    }
}
