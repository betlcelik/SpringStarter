package com.turkcell.springstarter.controllers;

import com.turkcell.springstarter.entities.Category;
import com.turkcell.springstarter.services.abstracts.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    List<Category> getAll(){
        return categoryService.getAll();
    }
}
