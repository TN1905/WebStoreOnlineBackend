package com.example.storeonline.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
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
@Table(name="shipping_method")
public class ShippingMethod {
    @Id
    private Integer shipping_method_id;
    private String shipping_method_name; 
    @OneToMany(mappedBy="shippingMethod", fetch=FetchType.EAGER)
    private List<Order> listOrder;
}
