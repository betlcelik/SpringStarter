package com.turkcell.springstarter.services.dtos.product.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import static com.turkcell.springstarter.services.constants.Messages.ValidationErrors.NOT_BLANK;
import static com.turkcell.springstarter.services.constants.Messages.ValidationErrors.SIZE;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddProductRequest {

    @NotBlank(message = NOT_BLANK)
    @Size(min =3, max=25, message = SIZE)
    private String name;

    @Min(0)
    private double unitPrice;
    @Min(0)
    private long stock;
    @Min(1)
    private int categoryId;
}
