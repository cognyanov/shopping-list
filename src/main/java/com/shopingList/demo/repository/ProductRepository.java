package com.shopingList.demo.repository;

import com.shopingList.demo.model.entity.ProductEntity;
import com.shopingList.demo.model.shopEnum.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <ProductEntity, Long> {

    List<ProductEntity> findByCategory_Name (CategoryEnum category);

    @Query ("select sum(p.price) from ProductEntity p")
    BigDecimal calcTotalPrice ();
}

