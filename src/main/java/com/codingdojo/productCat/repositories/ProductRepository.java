package com.codingdojo.productCat.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.productCat.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long>{

}
