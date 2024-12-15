package org.example.cursovayamarketplace.controller;

import lombok.RequiredArgsConstructor;
import org.example.cursovayamarketplace.servie.CategoryService;
import org.example.cursovayamarketplace.servie.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping
    public String getAllProducts(Model model){
        var products = productService.findAll();
        model.addAttribute("product", products);
        return "index";
    }

    @GetMapping("createPage")
    public String getCreatePage(Model model){
        var categories = categoryService.getAllCategories();
        model.addAttribute("category",categories);
        return "add-product";
    }

    @GetMapping("manageProductsPage")
    public String getManageProductsPage(@RequestParam int userId, Model model){
        var products = productService.getProductsByUserId(userId);
        model.addAttribute("product", products);
        return "manage-products";
    }

    @PostMapping("create")
    public String createProduct(
            @RequestParam String productTitle,
            @RequestParam int productPrice,
            @RequestParam String productCategory,
            @RequestParam String productDescription,
            @RequestParam String productImageUrl,
            @RequestParam int userId
    ){
        productService.createProduct(
                productTitle,
                productDescription,
                productImageUrl,
                productPrice,
                userId,
                productCategory);

        return "redirect:/product";
    }

}
