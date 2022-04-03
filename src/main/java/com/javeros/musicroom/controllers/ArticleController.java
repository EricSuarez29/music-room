package com.javeros.musicroom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javeros.musicroom.models.Article;
import com.javeros.musicroom.repository.IArticleRepository;

@Controller
@RequestMapping("/articles")
public class ArticleController {
	
private final IArticleRepository repository;
	
	@Autowired
	public ArticleController(IArticleRepository respository) {
		this.repository = respository;
	}
	
	@GetMapping
	public String showListArticle(Model model) {
		model.addAttribute("title", "Artículos");
		model.addAttribute("list", repository.findByStatus(1));
		return "article/article-list";
	}
	
	@PostMapping
	public String createArticle(Article article) {
		repository.save(article);
		return "redirect:/articles";
	}
	
	@GetMapping("/edit/{id}")
	public String getArticleToEdit(@PathVariable("id") Long id, Model model) {
		Article article = repository.getById(id);
		model.addAttribute("article", article);
		return "article/article-form";
	}
	
	@GetMapping("/form")
	public String showFormArticle(Article article, Model model) {
		model.addAttribute("title", "Artículo");
		return "article/article-form";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		repository.setStatusZero(id);
		return "redirect:/articles";
	}
}
