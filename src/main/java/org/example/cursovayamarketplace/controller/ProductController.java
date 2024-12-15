package org.example.cursovayamarketplace.controller;

import lombok.RequiredArgsConstructor;
import org.example.cursovayamarketplace.servie.CategoryService;
import org.example.cursovayamarketplace.servie.ProductService;
import org.example.cursovayamarketplace.servie.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final UserService userService;

    @GetMapping
    public String getAllProducts(Model model, Principal principal){
        var products = productService.findAll();
        var categories = categoryService.getAllCategories();
        model.addAttribute("product", products);
        model.addAttribute("category", categories);
        var user = userService.findUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/product")
    public String getProductById(@RequestParam("productId") int productId, Model model, Principal principal){
        var product = productService.getProductById(productId);
        model.addAttribute("product", product);
        var user = userService.findUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "product";
    }

    @GetMapping("/createPage")
    public String getCreatePage(Model model, Principal principal){
        var categories = categoryService.getAllCategories();
        model.addAttribute("category",categories);
        var user = userService.findUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "add-product";
    }

    @GetMapping("/manageProductsPage")
    public String getManageProductsPage(@RequestParam int userId, Model model, Principal principal){
        var products = productService.getProductsByUserId(userId);
        model.addAttribute("product", products);
        var user = userService.findUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "manage-products";
    }

    @PostMapping("/create")
    public String createProduct(
            @RequestParam String productTitle,
            @RequestParam int productPrice,
            @RequestParam String productCategory,
            @RequestParam String productDescription,
            @RequestParam String productImageUrl
    ){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        productService.createProduct(
                productTitle,
                productDescription,
                productImageUrl,
                productPrice,
                auth.getName(),
                productCategory);

        return "redirect:/product";
    }

    @GetMapping("/filterByCategory")
    public String getProductFilteredByCategory(@RequestParam int categoryId, Model model, Principal principal){
        var products = productService.getByCategory(categoryId);
        var categories = categoryService.getAllCategories();
        model.addAttribute("category",categories);
        model.addAttribute("product", products);
        var user = userService.findUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "index";
    }

    @PostMapping("/addToCart")
    public String addProductToCart(@RequestParam int productId, Principal principal){
        productService.addProductToCart(productId, principal.getName());
        return "redirect:/product";
    }

}
