package com.example.demo.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @GetMapping

    public String get() {
        return "GET:: admin controller";
    }
    @PostMapping

    public String post() {
        return "POST:: admin controller";
    }
    @PutMapping

    public String put() {
        return "PUT:: admin controller";
    }
    @DeleteMapping


    public String delete() {
        return "DELETE:: admin controller";
    }
}
