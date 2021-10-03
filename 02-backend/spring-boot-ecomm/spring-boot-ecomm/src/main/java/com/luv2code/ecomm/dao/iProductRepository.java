package com.luv2code.ecomm.dao;

import com.luv2code.ecomm.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
/*
    SpringBoot  = port 8080
    Angular     = port 4200

    Origin          = protocol  + hostname  + port  =   protocol    + hostname      + port   

    same origin     = http://   + localhost + :4200 =   http://     + localhost     + :4200

    !same origin    = http://   + localhost + :4200 =   http://     + localhost     + :8080
*/
// if you don't use CrossOrigin you will get an error!!!! ***IMPORTANT***
// Accept calls from web browser from this origin
@CrossOrigin("http://localhost:4200") // Where our Angular application is running on
//                                                      Product Entity, Long (key ID)
public interface iProductRepository extends JpaRepository<Product, Long>{    
}
