package org.example.cursovayamarketplace.servie;

import lombok.RequiredArgsConstructor;
import org.example.cursovayamarketplace.domain.CategoryRepository;
import org.example.cursovayamarketplace.domain.ProductRepository;
import org.example.cursovayamarketplace.domain.UserRepository;
import org.example.cursovayamarketplace.domain.model.CategoryEntity;
import org.example.cursovayamarketplace.domain.model.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public void createProduct(String title, String description, String imageUrl, int price, int userId, String categoryName){

        var user = userRepository.findById(userId).orElseThrow();

        var category = categoryRepository.findCategoryEntityByTitle(categoryName).orElseThrow();

        ProductEntity newProduct = new ProductEntity(
                title,
                description,
                price,
                imageUrl,
                category,
                user
        );
        productRepository.save(newProduct);
    }

    public ProductEntity getProductById(int id){
        return productRepository.findById(id).orElseThrow();
    }

    public List<ProductEntity> getProductsByUserId(int userId){
        var user = userRepository.findById(userId).orElseThrow();
        return productRepository.findProductEntitiesByUser(user);
    }

    public List<ProductEntity> findAll(){
        return new ArrayList<>(productRepository.findAll());
    }

    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }

    public ProductEntity updateProduct(int id, String title, String description, String imageUrl, int price, CategoryEntity category){
        var product = productRepository.findById(id).orElseThrow();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(imageUrl);
        product.setCategory(category);
        productRepository.save(product);
        return product;
    };

    public void addProductToCart(int productId, int userId){
        var user = userRepository.findById(userId).orElseThrow();
        var product = productRepository.findById(productId).orElseThrow();
        user.getCart().add(product);
        userRepository.save(user);
    }

}
