package com.dagtech.angularspringecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dagtech.angularspringecommerce.entity.ProductCategory;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel="productCategory", path="product-category")
public interface ProductCategoryRepository extends 
                             JpaRepository<ProductCategory, Long> {
	
	@Query(value="select * from product_category where category_name=:categoryName", nativeQuery=true)
	List<ProductCategory> findByCategoryName(@Param("categoryName") String categoryName);
	
	 
	
	 

}
