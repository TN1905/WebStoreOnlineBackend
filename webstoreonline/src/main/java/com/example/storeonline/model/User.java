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
@Table(name="users")
public class User {
    @Id
    private long id;
    private String username;
    private String password;
    @Column(columnDefinition="NVARCHAR(MAX)")
    private String firstname;
    @Column(columnDefinition="NVARCHAR(MAX)")
    private String lastname;
    @Column(columnDefinition="NVARCHAR(MAX)")
    private String gender;
    private String email;
    private String phone;
    @Column(columnDefinition="NVARCHAR(MAX)")
    private String address;
    private Boolean is_enable;
}
