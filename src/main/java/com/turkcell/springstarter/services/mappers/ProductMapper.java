package com.turkcell.springstarter.services.mappers;

import com.turkcell.springstarter.entities.Category;
import com.turkcell.springstarter.entities.Product;
import com.turkcell.springstarter.services.dtos.product.request.AddProductRequest;
import com.turkcell.springstarter.services.dtos.product.response.ProductListResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source="categoryId", target = "category.id")
    Product productFromAddRequest(AddProductRequest request);

    @Mapping(source = "product.id", target = "id")
    @Mapping(source = "product.name", target = "name")
    @Mapping(source = "category.name", target = "categoryName")
    ProductListResponse productListResponseFromProduct(Product product,Category category);

    default List<ProductListResponse> map(List<Product> products) {
        return products.stream()
                .map(product -> productListResponseFromProduct(product, product.getCategory()))
                .collect(Collectors.toList());
    }
}
