package com.codingdojo.productCat.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import com.codingdojo.productCat.models.Category;

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=1,max=50,message="Name can not be empty.")
	private String name;
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;
	
	@PrePersist
	public void onCreate() {this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate() {this.updatedAt = new Date();}
	
	
	//Setters and getters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="categories_products",
		//name is the foreign key:
		joinColumns=@JoinColumn(name="category_id"),
		inverseJoinColumns=@JoinColumn(name="product_id")
	)
	private List<Product> products;
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Product> getProducts(){
		return products;
	}
	
	// basic constructor:
	public Category() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
}
