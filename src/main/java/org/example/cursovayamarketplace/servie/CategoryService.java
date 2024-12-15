package org.example.cursovayamarketplace.servie;

import lombok.RequiredArgsConstructor;
import org.example.cursovayamarketplace.domain.CategoryRepository;
import org.example.cursovayamarketplace.domain.model.CategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryEntity> getAllCategories(){
        return categoryRepository.findAll();
    }

}
