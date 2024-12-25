package com.example.duan_pro2112.Category.service.implement;

import com.example.duan_pro2112.Category.entity.Category;
import com.example.duan_pro2112.Category.repository.CategoryRepo;
import com.example.duan_pro2112.Category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public List<Category> getAllCategory(){
        return categoryRepo.findAll();
    }

    @Override
    public Category addCategory(Category category){
        category.setId(null);
        return categoryRepo.save(category);
    }

    @Override
    public Category updateCategory(Category category){
        if (category.getId() == null || !categoryRepo.existsById(category.getId())) {
            throw new RuntimeException("Không tìm thấy id: " + category.getId());
        }
        Category existingCategory = categoryRepo.findById(category.getId()).orElseThrow(
                () -> new RuntimeException("Không tìm thấy id: " + category.getId())
        );
        existingCategory.setName(category.getName());
        existingCategory.setStatus(category.getStatus());
        existingCategory.setUpdatedAt(LocalDateTime.now());
        return categoryRepo.save(existingCategory);
    }

    @Override
    public void deleteCategory(Integer id){
        if (!categoryRepo.existsById(id)){
            throw new RuntimeException("Không tìm thấy id: "+ id);
        }
        categoryRepo.deleteById(id);
    }
}
