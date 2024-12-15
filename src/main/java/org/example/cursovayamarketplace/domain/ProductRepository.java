package org.example.cursovayamarketplace.domain;

import org.example.cursovayamarketplace.domain.model.CategoryEntity;
import org.example.cursovayamarketplace.domain.model.ProductEntity;
import org.example.cursovayamarketplace.domain.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    List<ProductEntity> findProductEntitiesByUser(UserEntity user);

    List<ProductEntity> findProductEntitiesByCategory(CategoryEntity category);

}
