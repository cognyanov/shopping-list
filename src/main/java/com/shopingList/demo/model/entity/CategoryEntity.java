package com.shopingList.demo.model.entity;

import com.shopingList.demo.model.shopEnum.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{
    @Enumerated (value = EnumType.STRING)
    private CategoryEnum name;

    @Column
    private String description;

    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "name=" + name +
                ", description='" + description + '\'' +
                '}';
    }

    public CategoryEntity() {
    }
}
