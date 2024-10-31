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
@Table(name="attribute_value")
public class AttributeValue {
    @Id
    private String attribute_value_id;
    @Column(columnDefinition="NVARCHAR(MAX)")
    private String attribute_value_name;
    private String attribute_value_description;
}
