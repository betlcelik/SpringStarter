package com.turkcell.springstarter.services.concretes;

import com.turkcell.springstarter.core.exceptions.types.BusinessException;
import com.turkcell.springstarter.core.services.abstracts.MessageService;
import com.turkcell.springstarter.entities.Category;
import com.turkcell.springstarter.entities.Product;
import com.turkcell.springstarter.repositories.abstracts.ProductRepository;
import com.turkcell.springstarter.services.abstracts.ProductService;
import com.turkcell.springstarter.services.dtos.product.request.AddProductRequest;
import com.turkcell.springstarter.services.dtos.product.response.ProductListResponse;
import com.turkcell.springstarter.services.mappers.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.turkcell.springstarter.services.constants.Messages.BusinessErrors.SAME_PRODUCT_ERROR;

@Service
@AllArgsConstructor
//classı impelmene edilen interface için IoC ye eklemiş oluyor
//yani Ioc içinde interface ve class ilişkisi tanımlı
public class ProductServiceImpl implements ProductService {

   // private ResourceBundleMessageSource bundleMessageSource;
    //iş akışını yönet
    private final ProductRepository productRespository;
    private final MessageSource messageSource;
    private final MessageService messageService;


    @Override
    public void add(AddProductRequest addProductRequest){
       ProductWithSameShouldNotExist(addProductRequest.getName());
        //Mapping -> Manual

        Category category = new Category();
        category.setId(addProductRequest.getCategoryId());
        Product product = ProductMapper.INSTANCE.productFromAddRequest(addProductRequest);

        //iş akışını yönet
        //gerekli durumda dataaccess e pasla
        productRespository.save(product);

    }

    @Override
    public List<ProductListResponse> getAll() {
        List<Product> productList= productRespository.findAll();
        List<ProductListResponse> response= ProductMapper.INSTANCE.map(productList);
        return response;
    }

    @Override
    public List<ProductListResponse> search(String query) {
        return productRespository.serachDto(query);
    }

    private void ProductWithSameShouldNotExist(String name){
        Optional<Product> productWithSameName=productRespository.findByName(name);
        if(productWithSameName.isPresent()){
            throw new BusinessException(messageService.getMessageWithArguments(SAME_PRODUCT_ERROR,name));
        }
    }
}
