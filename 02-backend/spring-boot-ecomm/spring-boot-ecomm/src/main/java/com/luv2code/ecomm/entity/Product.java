package com.luv2code.ecomm.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity                 // signifies that this is a JPA Entity
@Table(name="product")  // points to the table we'll be persisting
@Data                   // lombok saves us from doing getters/setters
 
public class Product {

    @Id                                                     // @Id = primary key column
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // @GeneratedValue = used for simple keys (1 column), used w/ @Id annotation
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;

    @Column(name = "sku")
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "active")
    private boolean active;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @Column(name = "date_created")
    @CreationTimestamp              // Hibernate annotation that will automatically manage the timestamps
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp                // Hibernate annotation that will automatically manage the timestamps
    private Date lastUpdated;
    
    
}
