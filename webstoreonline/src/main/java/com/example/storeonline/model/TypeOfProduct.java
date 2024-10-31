package com.example.storeonline.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private String type_product_id;
    @Column(columnDefinition="NVARCHAR(MAX)")
    private String type_product_name;
    @Column(columnDefinition="NVARCHAR(MAX)")
    private String type_product_description;
}
