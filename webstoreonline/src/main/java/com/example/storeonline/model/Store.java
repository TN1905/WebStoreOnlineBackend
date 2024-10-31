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
@Table(name="store")
public class Store {
    @Id
    private Long store_id;
    @Column(columnDefinition="NVARCHAR(MAX)")
    private String store_name;
    @Column(columnDefinition="NVARCHAR(MAX)")
    private String store_slogan;
    @Temporal(TemporalType.DATE)
    private Date create_date;
    private String address;
    private String phone;
}
