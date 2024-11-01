package com.example.storeonline.model;

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
@Table(name="users")
public class User {
    @Id
    private long user_id;
    private String username;
    private String password;
    @Column(columnDefinition="VARCHAR(255) CHARACTER SET utf8mb4")
    private String firstname;
    @Column(columnDefinition="VARCHAR(255) CHARACTER SET utf8mb4")
    private String lastname;
    @Column(columnDefinition="VARCHAR(255) CHARACTER SET utf8mb4")
    private String gender;
    private String email;
    private String phone;
    @Column(columnDefinition="VARCHAR(255) CHARACTER SET utf8mb4")
    private String address;
    private Boolean is_enable;
    @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name="confirmation_token_user", joinColumns= {@JoinColumn(name="user_id", referencedColumnName="user_id")},
        inverseJoinColumns= {@JoinColumn(name="confirmationTokenId", referencedColumnName="confirmation_token_id")})
    private Set<ConfirmationToken> confirmationTokens = new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name="session_user", joinColumns= {@JoinColumn(name="user_id", referencedColumnName="user_id")},
        inverseJoinColumns= {@JoinColumn(name="session_id", referencedColumnName="session_id")})
    private Set<Sessions> session = new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name="role_user", joinColumns={@JoinColumn(name="user_id", referencedColumnName="user_id")},
        inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="role_id")})
    private Set<Roles> role = new HashSet<>();
    @OneToMany(mappedBy="user", fetch=FetchType.EAGER)
    private List<Store> listStore;
    @OneToMany(mappedBy="user", fetch=FetchType.EAGER)
    private List<Order> listOrder;
}
