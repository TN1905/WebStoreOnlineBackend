package com.example.storeonline.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="attribute")
public class Attribute {
    @Id
    private String attribute;
    @Column(columnDefinition="NVARCHAR(MAX)")
    private String attribute_name;
    @Column(columnDefinition="NVARCHAR(MAX)")
    private String attribute_description;
}
