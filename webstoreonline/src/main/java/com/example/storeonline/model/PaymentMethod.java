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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="payment_method")
public class PaymentMethod {
    @Id
    private Integer payment_method_id;
    private String payment_method_name;
    @OneToMany(mappedBy="paymentMethod",fetch=FetchType.EAGER)
    private List<Payment> payment;
}
