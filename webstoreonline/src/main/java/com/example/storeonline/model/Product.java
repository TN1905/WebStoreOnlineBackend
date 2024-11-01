package com.example.storeonline.model;

import java.util.Date;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @Column(columnDefinition="VARCHAR(255) CHARACTER SET utf8mb4")
    private String product_name;
    private Double product_price;
    @Temporal(TemporalType.DATE)
    private Date create_date;
    @Column(columnDefinition="VARCHAR(255) CHARACTER SET utf8mb4")
    private String description;
    private int quantity;
    @ManyToOne @JoinColumn(name="store_id")
    private Store store;
    @ManyToOne @JoinColumn(name="type_of_product_id")
    private TypeOfProduct type_of_product;
    @OneToMany(mappedBy="product")
    private List<OrderDetail> listOrderDetail;
    @ManyToMany(fetch=FetchType.EAGER)
        @JoinTable(name="product_attribute_value", joinColumns= {@JoinColumn(name="product_id",referencedColumnName="product_id")},
        inverseJoinColumns={@JoinColumn(name="attribute_value_id",referencedColumnName="attribute_value_id")})
    private Set<AttributeValue> attributeValues= new HashSet<>();
    @ManyToMany(fetch=FetchType.EAGER)
        @JoinTable(name="product_image", joinColumns = {@JoinColumn(name = "product_id",referencedColumnName="product_id")},
        inverseJoinColumns= {@JoinColumn(name = "image_id", referencedColumnName="image_id")})
    private Set<Image> image = new HashSet<>();
}
