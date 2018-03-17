package com.codingdojo.productCat.controllers;

import java.util.ArrayList;
import java.util.List;

import com.codingdojo.productCat.models.Category;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productCat.models.Product;
import com.codingdojo.productCat.services.CategoryService;
import com.codingdojo.productCat.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	private ProductService pS;
	private CategoryService cS;
	
	public ProductController(ProductService pS, CategoryService cS) {
		this.pS = pS;
		this.cS = cS;
	}
	
	@RequestMapping("/new")
	public String create(@ModelAttribute("product") Product newProduct, Model model) {
		model.addAttribute("products", pS.all());
		return "product.jsp";
	}
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("product") Product newProduct, BindingResult res) {
		if (res.hasErrors()){
			return "product.jsp";
		}
		
		pS.create(newProduct);
		return "redirect:/product/new";
	}
	
	@RequestMapping("{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		model.addAttribute("categories", cS.all());
		model.addAttribute("products", pS.all());
		model.addAttribute("product", pS.find(id));
		return "showProduct.jsp";
	}
	
	@PostMapping("{product_id}/join")
	public String join(@RequestParam("category_id") Long category_id, @PathVariable("product_id") Long product_id) {
		
		Product product = pS.find(product_id);
		List<Category> categories = product.getCategories();
		Category category = cS.find(category_id);
		categories.add(category);
		product.setCategories(categories);
		
		pS.update(product);
		System.out.print(category_id);
		System.out.print(product_id);
		return "redirect:/product/"+product_id;
	}
}
