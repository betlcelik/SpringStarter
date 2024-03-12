package com.turkcell.springstarter.services.abstracts;

import com.turkcell.springstarter.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
}
