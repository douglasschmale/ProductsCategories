package com.codingdojo.productCat.services;

import com.codingdojo.productCat.models.Category;
import com.codingdojo.productCat.repositories.CategoryRepository;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	private CategoryRepository cR;
	
	public CategoryService(CategoryRepository cR) {
		this.cR = cR;
	}
	
	public void create(Category cat) {
		cR.save(cat);
	}
	
	public ArrayList<Category> all(){
		return (ArrayList<Category>) cR.findAll();
	}
	
	public Category find(Long id) {
		return cR.findById(id).orElse(null);
	}
	
	//Update
	public void update(Category thisCategory) {
		cR.save(thisCategory);
	}
	
	public void destroy(Category cat) {
		cR.delete(cat);
	}
}
