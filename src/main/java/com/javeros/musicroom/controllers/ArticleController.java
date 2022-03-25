package com.javeros.musicroom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String showProductList(Model model) {
		model.addAttribute("title", "Artículo");
		model.addAttribute("list", repository.findAll());
		return "articles/articles-list";
	}
	
	@GetMapping("/form")
	public String showProductForm(Model model) {
		model.addAttribute("title", "Artículo");
		return "articles/articles-form";
	}
}
