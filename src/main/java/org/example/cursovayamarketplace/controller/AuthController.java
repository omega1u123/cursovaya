package org.example.cursovayamarketplace.controller;

import lombok.RequiredArgsConstructor;
import org.example.cursovayamarketplace.dto.RegisterFormData;
import org.example.cursovayamarketplace.servie.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping
    public String getAuthPage(Model model){
        return "auth";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("registerForm") RegisterFormData registerFormData) {
        userService.createUser(registerFormData.username(), registerFormData.password());
        return "registered";
    }




}
