package com.turkcell.springstarter.controllers;

import com.turkcell.springstarter.entities.Product;
import com.turkcell.springstarter.services.abstracts.ProductService;
import com.turkcell.springstarter.services.dtos.product.request.AddProductRequest;
import com.turkcell.springstarter.services.dtos.product.response.ProductListResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class ProductsController {
    //endpoint yönet
    //@autowired da constructorda yapılan dependecy injection gibi işliyor
    private ProductService productService;


    @PostMapping
    public void add(@RequestBody @Valid AddProductRequest addProductRequest){
         productService.add(addProductRequest);
    }

   @GetMapping
    public List<ProductListResponse> get() {
        return productService.getAll();
    }

    @GetMapping("/search")
    List<ProductListResponse> search(@RequestParam String query) {
        return productService.search(query);

    }
}
