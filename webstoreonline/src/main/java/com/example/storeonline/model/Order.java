package com.example.storeonline.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order {
    @Id
    private Long order_id;
    @Temporal(TemporalType.DATE)
    private Date order_date;
    private int quantity;
    @Column(columnDefinition="VARCHAR(255) CHARACTER SET utf8mb4")
    private String description;
    private Double discount;
    @ManyToOne @JoinColumn(name="user_id")
    private User user;
    @OneToMany(mappedBy="order",fetch= FetchType.EAGER)
    private List<OrderDetail> listOrderDetail;
    @OneToMany(mappedBy="order",fetch= FetchType.EAGER)
    private List<Payment> listPayment;
    @ManyToOne @JoinColumn(name="shipping_method_id")
    private ShippingMethod shippingMethod;
}
