package com.news.springboot.services;

import com.news.springboot.dto.NewsDto;
import com.news.springboot.entity.Category;
import com.news.springboot.entity.News;
import com.news.springboot.repositories.CategoryRepositories;
import com.news.springboot.repositories.NewsRepositories;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Slf4j
@Service
public class NewsCRUDServices implements CRUDServices<NewsDto> {

    private final NewsRepositories newsRepositories;

    private final CategoryRepositories categoryRepositories;

    @Override
    public NewsDto getById(Integer id) {
        log.info("Get by ID: " + id);
        return mapToDto(newsRepositories.findById(id).orElseThrow());
    }

    @Override
    public Collection<NewsDto> getAll() {
        log.info("Get all");
        return newsRepositories.findAll()
                .stream()
                .map(NewsCRUDServices::mapToDto)
                .toList();
    }

    @Override
    public void create(NewsDto newsDto) {
        log.info("Create");
        News news = mapToEntity(newsDto);
        Integer categoryId = newsDto.getCategoryId();
        Category category = categoryRepositories.findById(categoryId).orElseThrow();
        news.setCategory(category);
        newsRepositories.save(news);
    }

    @Override
    public void update(Integer id, NewsDto newsDto) {
        log.info("Update");
        News news = mapToEntity(newsDto);
        Integer categoryId = newsDto.getCategoryId();
        Category category = categoryRepositories.findById(categoryId).orElseThrow();
        news.setCategory(category);
        newsRepositories.save(news);
    }

    @Override
    public void delete(Integer id) {
        log.info("Delete " + id);
        newsRepositories.deleteById(id);
    }

    public static NewsDto mapToDto(News news) {
        NewsDto newsDto = new NewsDto();
        newsDto.setId(news.getId());
        newsDto.setTitle(news.getTitle());
        newsDto.setText(news.getText());
        newsDto.setDate(news.getDate());
        return newsDto;
    }

    public static News mapToEntity(NewsDto newsDto) {
        News news = new News();
        news.setId(newsDto.getId());
        news.setTitle(newsDto.getTitle());
        news.setText(newsDto.getText());
        news.setDate(newsDto.getDate());
        return news;
    }
}
