package com.news.springboot.controllers;

import com.news.springboot.dto.CategoryDto;
import com.news.springboot.services.CategoryCRUDServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping(path = "/category")
@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryCRUDServices categoryServices;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Integer id) {
        CategoryDto category = categoryServices.getById(id);
        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category with id = " + id + " not found");
        }
        return ResponseEntity.ok(category);
    }

    @GetMapping
    public ResponseEntity<Collection<CategoryDto>> getAllCategory() {
        Collection<CategoryDto> allCategory = categoryServices.getAll();
        if (allCategory.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(allCategory);
        }
        return ResponseEntity.ok(allCategory);
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto categoryDto) {
        categoryServices.create(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Integer id, @RequestBody CategoryDto categoryDto) {
        CategoryDto category = categoryServices.getById(id);
        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("News with id = " + id + " not found");
        }
        categoryServices.update(id, categoryDto);
        return ResponseEntity.status(HttpStatus.OK).body(categoryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable Integer id) {
        CategoryDto category = categoryServices.getById(id);
        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("News with id = " + id + " not found");
        }
        categoryServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("News with id = " + id + " delete");
    }
}