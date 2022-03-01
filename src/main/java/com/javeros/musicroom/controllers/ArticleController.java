package com.javeros.musicroom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
public class ArticleController {
	
	@GetMapping
	public String showProductList(Model model) {
		model.addAttribute("title", "Artículo");
		return "articles/articles-list";
	}
	
	@GetMapping("/form")
	public String showProductForm(Model model) {
		model.addAttribute("title", "Artículo");
		return "articles/articles-form";
	}
}
