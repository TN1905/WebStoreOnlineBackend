package com.example.storeonline.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
    private String attribute_id;
    @Column(columnDefinition="VARCHAR(255) CHARACTER SET utf8mb4")
    private String attribute_name;
    @Column(columnDefinition="VARCHAR(255) CHARACTER SET utf8mb4")
    private String attribute_description;
    @OneToMany(mappedBy="attribute",fetch=FetchType.EAGER)
    private List<AttributeValue> listAttributeValue;
    @ManyToMany(fetch=FetchType.EAGER)
        @JoinTable(name="type_of_product_attribute", joinColumns={@JoinColumn(name="attribute_id",referencedColumnName="attribute_id")},
        inverseJoinColumns={@JoinColumn(name="type_of_product_id", referencedColumnName="type_of_product_id")})
    private Set<TypeOfProduct> type_of_product= new HashSet<>();
}
