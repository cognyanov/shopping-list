package com.shopingList.demo.binding;

import com.shopingList.demo.model.shopEnum.CategoryEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class ProductBindingModel {

    @Size (min = 3, max = 20, message = "product name must be min-3 and max-20 characters")
    @NotBlank (message = "please enter product name")
    private String name;

    @Size (min = 5, message = "description must be min-5 characters")
    @NotBlank (message = "please enter description")
    private String description;

    @DecimalMin(value = "0", message = "price must be possitive")
    private BigDecimal price;

    @DateTimeFormat (pattern = "yyyy-MM-dd")
    @FutureOrPresent (message = "please chose valid date")
    private LocalDate neededBefore;

    @NotNull (message = "please chose category")
    private CategoryEnum category;

    public ProductBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getNeededBefore() {
        return neededBefore;
    }

    public void setNeededBefore(LocalDate neededBefore) {
        this.neededBefore = neededBefore;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }
}
