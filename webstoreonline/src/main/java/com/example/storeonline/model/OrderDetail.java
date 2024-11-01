package com.example.storeonline.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="order_detail")
public class OrderDetail {
    @Id
    private Long order_detail_id;
    private int quantity;
    private double unit_price;
    private double discount;
    @ManyToOne @JoinColumn(name="order_id")
    private Order order;
    @ManyToOne @JoinColumn(name="product_id")
    private Product product;
}
