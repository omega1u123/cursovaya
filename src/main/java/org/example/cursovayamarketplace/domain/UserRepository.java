package org.example.cursovayamarketplace.domain;

import org.example.cursovayamarketplace.domain.model.ProductEntity;
import org.example.cursovayamarketplace.domain.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUsername(String username);

    List<UserEntity> findAllByCart(List<ProductEntity> cart);

}
