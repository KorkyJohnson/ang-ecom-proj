package com.luv2code.ecomm.dao;

import com.luv2code.ecomm.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
//                                                      Product Entity, Long (key ID)
public interface iProductRepository extends JpaRepository<Product, Long>{    
}
