package com.example.storeonline.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name="order")
public class Order {
    @Id
    private Long order_id;
    @Temporal(TemporalType.DATE)
    private Date order_date;
    private int quantity;
    @Column(columnDefinition="NVARCHAR(MAX)")
    private String description;
    private Double discount;
}
