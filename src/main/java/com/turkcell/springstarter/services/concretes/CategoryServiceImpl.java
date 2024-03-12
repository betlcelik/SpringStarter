package com.turkcell.springstarter.services.concretes;

import com.turkcell.springstarter.entities.Category;
import com.turkcell.springstarter.repositories.abstracts.CategoryRepository;
import com.turkcell.springstarter.services.abstracts.CategoryService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }
}
