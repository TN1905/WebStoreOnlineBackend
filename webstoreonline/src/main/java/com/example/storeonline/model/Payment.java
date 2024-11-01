package com.example.storeonline.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="payment")
public class Payment {
    @Id
    private Long payment_id;
    private Double payment_amount;
    @Temporal(TemporalType.DATE)
    private Date payment_date;
    private String payment_number;
    @ManyToOne @JoinColumn(name="order_id")
    private Order order;
    @ManyToOne @JoinColumn(name="payment_method_id")
    private PaymentMethod paymentMethod;
}
