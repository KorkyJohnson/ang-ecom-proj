package com.luv2code.ecomm.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// import lombok.Getter;
// import lombok.Setter;
import lombok.Data;


@Entity
@Table(name = "product_category")

@Data //- known bug in lombok @Data w/ 1:many so we user @Getter/@Setter instead
//@Getter
//@Setter

public class ProductCategory {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category") // means category 
    private Set<Product> products;
    
}
