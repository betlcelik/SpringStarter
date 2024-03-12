package com.turkcell.springstarter.services.dtos.product.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductListResponse {
    private int id;
    private String name;
    private String categoryName;
    private double unitPrice;
}
