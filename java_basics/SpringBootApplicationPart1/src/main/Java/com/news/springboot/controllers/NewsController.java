package com.news.springboot.controllers;

import com.news.springboot.dto.NewsDto;
import com.news.springboot.services.NewsCRUDServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RequestMapping(path = "/news")
@RestController
public class NewsController {
    private final NewsCRUDServices newsServices;

    public NewsController(NewsCRUDServices newsCRUDServices) {
        this.newsServices = newsCRUDServices;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNewsById(@PathVariable Long id) {
        NewsDto news = newsServices.getById(id);
        if (news == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("News with id = " + id + " not found");
        }
        return ResponseEntity.ok(news);
    }

    @GetMapping
    public ResponseEntity<Collection<NewsDto>> getAllNews() {
        Collection<NewsDto> allNews = newsServices.getAll();
        if (allNews.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(allNews);
        }
        return ResponseEntity.ok(allNews);
    }

    @PostMapping
    public ResponseEntity<?> createNews(@RequestBody NewsDto newsDto) {
        newsServices.create(newsDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newsDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateNews(@PathVariable Long id, @RequestBody NewsDto newsDto) {
        NewsDto news = newsServices.getById(id);
        if (news == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("News with id = " + id + " not found");
        }
        newsServices.update(id, newsDto);
        return ResponseEntity.status(HttpStatus.OK).body(newsDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable Long id) {
        NewsDto newsDto = newsServices.getById(id);
        if (newsDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("News with id = " + id + " not found");
        }
        newsServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("News with id = " + id + " delete");
    }
}
