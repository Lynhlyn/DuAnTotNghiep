package com.example.duan_pro2112.Category.controller;

import com.example.duan_pro2112.Category.entity.Category;
import com.example.duan_pro2112.Category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:8080")
public class CategoryController {
    @Autowired
    CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        return ResponseEntity.ok(service.getAllCategory());
    }

    @PostMapping("/add")
    public ResponseEntity<Category> add(@RequestBody Category category){
        return ResponseEntity.ok(service.addCategory(category));
    }

    @PutMapping("/update")
    public ResponseEntity<Category> update(@RequestBody Category category){
        return ResponseEntity.ok(service.updateCategory(category));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") Integer id){
        try {
            service.deleteCategory(id);
            return ResponseEntity.ok("Xoá thành công!!!");
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lỗi 400(Lỗi Request)" + e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi 500(Lỗi Server)" + e.getMessage());
        }
    }
}
