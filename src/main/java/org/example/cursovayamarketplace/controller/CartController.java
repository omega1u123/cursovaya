package org.example.cursovayamarketplace.controller;

import lombok.RequiredArgsConstructor;
import org.example.cursovayamarketplace.domain.UserRepository;
import org.example.cursovayamarketplace.servie.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("cart")
@RequiredArgsConstructor
public class CartController {

    private final UserService userService;

    @GetMapping
    public String getCartPage(Model model, Principal principal){
        var user = userService.findUserByUsername(principal.getName());
        var cartProducts = user.getCart();
        model.addAttribute("product", cartProducts);
        model.addAttribute("user", user);
        return "cart";
    }
}
