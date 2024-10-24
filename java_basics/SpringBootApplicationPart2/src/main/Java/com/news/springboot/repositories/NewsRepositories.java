package com.news.springboot.repositories;

import com.news.springboot.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepositories extends JpaRepository<News, Integer> {
}
