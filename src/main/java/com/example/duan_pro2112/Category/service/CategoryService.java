package com.example.duan_pro2112.Category.service;

import com.example.duan_pro2112.Category.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();

    Category addCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategory(Integer id);
}
