package com.turkcell.springstarter.repositories.abstracts;

import com.turkcell.springstarter.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
