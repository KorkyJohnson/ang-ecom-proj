package com.luv2code.ecomm.dao;

import com.luv2code.ecomm.entity.ProductCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//                                               JSON Entry         path /product-category
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface iProductCategoryRepository extends JpaRepository<ProductCategory, Long> {    
}
