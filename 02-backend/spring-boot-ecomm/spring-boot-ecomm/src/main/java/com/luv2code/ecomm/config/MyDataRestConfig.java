package com.luv2code.ecomm.config;

// If you get an error on these imports do a Java Server Clean (CTRL+SHIFT+P 'Java clean')
import com.luv2code.ecomm.entity.Product;
import com.luv2code.ecomm.entity.ProductCategory;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        // TODO Auto-generated method stub
        // RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        // disable HTTP methods for Product: PUT, POST and DELETE
        config.getExposureConfiguration()
            .forDomainType(Product.class)
            .withItemExposure((metdata, HttpMethods) -> HttpMethods.disable(theUnsupportedActions))
            .withCollectionExposure((metdata, HttpMethods) -> HttpMethods.disable(theUnsupportedActions));

        // disable HTTP methods for ProductCategory: PUT, POST and DELETE
        config.getExposureConfiguration()
            .forDomainType(ProductCategory.class)
            .withItemExposure((metdata, HttpMethods) -> HttpMethods.disable(theUnsupportedActions))
            .withCollectionExposure((metdata, HttpMethods) -> HttpMethods.disable(theUnsupportedActions));
    }

    
    
}
