package com.codingdojo.productCat.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.productCat.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long>{

}
