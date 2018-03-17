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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import com.codingdojo.productCat.models.Category;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=1,max=50,message="Name can not be empty.")
	private String name;
	
	@Size(min=1,max=1024,message="Please provide a description.")
	private String description;
	
	@NotNull
	private double price;
	
	

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
		return this.id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String desc) {
		this.description = desc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	
	//relationship mapping
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="categories_products",
		//name is the foreign key:
		joinColumns=@JoinColumn(name="product_id"),
		inverseJoinColumns=@JoinColumn(name="category_id")
	)
	private List<Category> categories;
	
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public List<Category> getCategories(){
		return categories;
	}
	
	// basic constructor:
	public Product() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
}
