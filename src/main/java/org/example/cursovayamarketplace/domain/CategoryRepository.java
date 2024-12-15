package org.example.cursovayamarketplace.domain;

import org.example.cursovayamarketplace.domain.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

    Optional<CategoryEntity> findCategoryEntityByTitle(String categoryTitle);

}
