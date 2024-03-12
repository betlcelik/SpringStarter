package com.turkcell.springstarter.services.mappers;

import com.turkcell.springstarter.entities.Category;
import com.turkcell.springstarter.entities.Product;
import com.turkcell.springstarter.services.dtos.product.request.AddProductRequest;
import com.turkcell.springstarter.services.dtos.product.response.ProductListResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-13T00:58:16+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product productFromAddRequest(AddProductRequest request) {
        if ( request == null ) {
            return null;
        }

        Product product = new Product();

        product.setCategory( addProductRequestToCategory( request ) );
        product.setName( request.getName() );
        product.setUnitPrice( request.getUnitPrice() );
        product.setStock( request.getStock() );

        return product;
    }

    @Override
    public ProductListResponse productListResponseFromProduct(Product product, Category category) {
        if ( product == null && category == null ) {
            return null;
        }

        ProductListResponse productListResponse = new ProductListResponse();

        if ( product != null ) {
            productListResponse.setId( product.getId() );
            productListResponse.setName( product.getName() );
            productListResponse.setUnitPrice( product.getUnitPrice() );
        }
        if ( category != null ) {
            productListResponse.setCategoryName( category.getName() );
        }

        return productListResponse;
    }

    protected Category addProductRequestToCategory(AddProductRequest addProductRequest) {
        if ( addProductRequest == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( addProductRequest.getCategoryId() );

        return category;
    }
}
