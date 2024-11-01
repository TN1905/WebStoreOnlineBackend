package com.example.storeonline.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="type_of_product")
public class TypeOfProduct {
    @Id
    private String type_of_product_id;
    @Column(columnDefinition="VARCHAR(255) CHARACTER SET utf8mb4")
    private String type_product_name;
    @Column(columnDefinition="VARCHAR(255) CHARACTER SET utf8mb4")
    private String type_product_description;
    @OneToMany(mappedBy="type_of_product")
    private List<Product> listProduct;
}
