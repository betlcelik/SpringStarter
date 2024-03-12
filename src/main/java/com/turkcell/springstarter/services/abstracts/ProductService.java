package com.turkcell.springstarter.services.abstracts;

import com.turkcell.springstarter.entities.Product;
import com.turkcell.springstarter.services.dtos.product.request.AddProductRequest;
import com.turkcell.springstarter.services.dtos.product.response.ProductListResponse;

import java.util.List;

public interface ProductService {
    void add(AddProductRequest addProductRequest);
    List<ProductListResponse> getAll();
    List<ProductListResponse> search(String query);
}
