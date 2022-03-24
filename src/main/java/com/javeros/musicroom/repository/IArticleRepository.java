package com.javeros.musicroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javeros.musicroom.models.Article;

public interface IArticleRepository extends JpaRepository<Article, Long>{
	
}
