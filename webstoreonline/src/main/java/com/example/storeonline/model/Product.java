package com.example.storeonline.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product")
public class Product {
    @Id
    private String product_id;
    @Column(columnDefinition="NVARCHAR(MAX)")
    private String product_name;
    private Double product_price;
    @Temporal(TemporalType.DATE)
    private Date create_date;
    @Column(columnDefinition="NVARCHAR(MAX)")
    private String description;
    private int quantity;
}
