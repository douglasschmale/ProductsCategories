package com.codingdojo.productCat.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productCat.models.Category;
import com.codingdojo.productCat.models.Product;
import com.codingdojo.productCat.services.CategoryService;
import com.codingdojo.productCat.services.ProductService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	private CategoryService cS;
	private ProductService pS;
	
	public CategoryController(CategoryService cS, ProductService pS) {
		this.cS = cS;
		this.pS = pS;
	}
	
	@RequestMapping("/new")
	public String categories(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("categories", cS.all());
		return "categories.jsp";
	}
	
	@PostMapping("/new")
	public String createCat(@Valid @ModelAttribute("category") Category cat, BindingResult res) {
		if(res.hasErrors()) return "categories.jsp";
		cS.create(cat);
		return "redirect:/category/new";
	}
	
	@RequestMapping("{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		model.addAttribute("products", pS.all());
		model.addAttribute("categories", cS.all());
		model.addAttribute("category", cS.find(id));
		System.out.print(pS.all());

		return "showCategory.jsp";
	}
	
	@PostMapping("{category_id}/join")
	public String join(@RequestParam("product_id") Long product_id, @PathVariable("category_id") Long category_id) {
		
		Category category = cS.find(category_id);
		List<Product> products = category.getProducts();
		Product product = pS.find(product_id);
		products.add(product);
		category.setProducts(products);
		
		cS.update(category);
		return "redirect:/categories/"+category_id;
	}
}
