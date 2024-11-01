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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="store")
public class Store {
    @Id
    private Long store_id;
    @Column(columnDefinition="VARCHAR(255) CHARACTER SET utf8mb4")
    private String store_name;
    @Column(columnDefinition="VARCHAR(255) CHARACTER SET utf8mb4")
    private String store_slogan;
    @Temporal(TemporalType.DATE)
    private Date create_date;
    private String address;
    private String phone;
    @OneToMany(mappedBy="store", fetch=FetchType.EAGER)
    List<Product> listProduct;
    @ManyToOne @JoinColumn(name="user_id")
    private User user;
    @ManyToMany(fetch= FetchType.EAGER)
        @JoinTable(name="store_image", joinColumns= {@JoinColumn(name="store_id", referencedColumnName="store_id")},
        inverseJoinColumns= {@JoinColumn(name="image_id",referencedColumnName="image_id")})
    private Set<Image> image= new HashSet<>();
}
