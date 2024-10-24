package com.news.springboot.services;

import com.news.springboot.dto.CategoryDto;
import com.news.springboot.entity.Category;
import com.news.springboot.repositories.CategoryRepositories;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;


@RequiredArgsConstructor
@Slf4j
@Service
public class CategoryCRUDServices implements CRUDServices<CategoryDto> {

    private final CategoryRepositories categoryRepositories;

    @Override
    public CategoryDto getById(Integer id) {
        log.info("Get by ID: " + id);
        return mapToDto(categoryRepositories.findById(id).orElseThrow());
    }

    @Override
    public Collection<CategoryDto> getAll() {
        log.info("Get all");
        return categoryRepositories.findAll().stream()
                .map(CategoryCRUDServices::mapToDto)
                .toList();
    }

    @Override
    public void create(CategoryDto categoryDto) {
        log.info("Create");
        Category category = mapToEntity(categoryDto);
        categoryRepositories.save(category);
    }

    @Override
    public void update(Integer id, CategoryDto categoryDto) {
        log.info("Update");
        Category category = mapToEntity(categoryDto);
        categoryRepositories.save(category);
    }

    @Override
    public void delete(Integer id) {
        log.info("Delete " + id);
        categoryRepositories.deleteById(id);
    }

    public static CategoryDto mapToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setTitle(category.getTitle());
        categoryDto.setNews(category.getNews());
        return categoryDto;
    }

    public static Category mapToEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setTitle(categoryDto.getTitle());
        category.setNews(categoryDto.getNews());
        return category;
    }
}
