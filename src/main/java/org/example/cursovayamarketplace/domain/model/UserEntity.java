package org.example.cursovayamarketplace.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_t")
@NoArgsConstructor
@Getter
@Setter
public class UserEntity extends BaseEntity{

    @Column(unique = true)
    private String username;
    private String password;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<ProductEntity> product = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "cart",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductEntity> cart = new ArrayList<>();

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
