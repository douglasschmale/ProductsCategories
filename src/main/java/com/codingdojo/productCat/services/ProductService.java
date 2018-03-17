package com.codingdojo.productCat.services;

import com.codingdojo.productCat.models.Product;
import com.codingdojo.productCat.repositories.CategoryRepository;
import com.codingdojo.productCat.repositories.ProductRepository;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	private ProductRepository pR;
	
	public ProductService(ProductRepository pR) {
		this.pR = pR;
	}
	
	public void create(Product pro) {
		pR.save(pro);
	}
	
	public ArrayList<Product> all(){
		return (ArrayList<Product>) pR.findAll();
	}
	
	public Product find(Long id) {
		return pR.findById(id).orElse(null);
	}
	//Update
	public void update(Product thisProduct) {
		pR.save(thisProduct);
	}
	
	public void destroy(Product pro) {
		pR.delete(pro);
	}
}
