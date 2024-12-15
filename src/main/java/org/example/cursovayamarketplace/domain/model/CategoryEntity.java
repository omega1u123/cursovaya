package org.example.cursovayamarketplace.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
public class CategoryEntity extends BaseEntity{

   private String title;

   @OneToMany(mappedBy = "category")
   private List<ProductEntity> products = new ArrayList<>();

}
