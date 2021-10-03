package com.luv2code.ecomm.dao;

import com.luv2code.ecomm.entity.ProductCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
//                                               JSON Entry         path /product-category
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface iProductCategoryRepository extends JpaRepository<ProductCategory, Long> {    
}
