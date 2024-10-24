package com.news.springboot.services;

import com.news.springboot.dto.NewsDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Getter
@Setter
public class NewsCRUDServices implements CRUDServices<NewsDto> {

    private final ConcurrentHashMap<Long, NewsDto> baseNews = new ConcurrentHashMap<>();

    @Override
    public NewsDto getById(Long id) {
        if (baseNews.size() < id || id < 0) {
            System.out.println("Error Incorrect id: " + id);
        }
        System.out.println("Get News by ID: " + id);
        return baseNews.get(id);
    }

    @Override
    public Collection<NewsDto> getAll() {
        if (baseNews.isEmpty()) {
            System.out.println("Error base is empty");
        }
        System.out.println("Get all News");
        return baseNews.values();
    }

    @Override
    public void create(NewsDto item) {
        long baseId = 1L;
        // Если база пуста создать первую запись в базу
        if (baseNews.isEmpty()) {
            item.setId(baseId);
            item.setDate(new Date());
            baseNews.put(baseId, item);
            System.out.println("Create First News");
            return;
        }
        // Если в базе есть свободные Ид использовать их
        if (!baseNews.isEmpty()) {
            for (long id = 1L; id <= baseNews.size(); id++) {
                if (!baseNews.containsKey(id)) {
                    item.setId(id);
                    item.setDate(new Date());
                    baseNews.put(id, item);
                    System.out.println("Create News in base");
                    return;
                }
            }
        }
        // Создать новую запись в базу
        if (!baseNews.isEmpty()) {
            long newId = baseNews.size() + 1L;
            item.setId(newId);
            item.setDate(new Date());
            baseNews.put(newId, item);
            System.out.println("Create Last News");
        }
    }

    @Override
    public void update(Long id, NewsDto item) {
        if (!baseNews.containsKey(id)) {
            System.out.println("News with id " + id +" not found");
            return;
        }
        item.setId(id);
        item.setDate(new Date());
        baseNews.put(id, item);
        System.out.println("Update News with id: " + id);
    }

    @Override
    public void delete(Long id) {
        if (!baseNews.containsKey(id)) {
            System.out.println("News with id " + id +" not found");
            return;
        }
        System.out.println("Delete " + id);
        baseNews.remove(id);
    }
}
