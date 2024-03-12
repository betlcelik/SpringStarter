package com.turkcell.springstarter.repositories.abstracts;

import com.turkcell.springstarter.entities.Product;
import com.turkcell.springstarter.services.dtos.product.response.ProductListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    //jpql -> jpa sql
    //Query("select p from Product where lower p.name Lİke %:query%)

   // @Query(value="select p from Product where lower p.name Lİke %:p1%)
    //List<Product> search(@Param("p1") String query);

    //native query
    //@Query(value="Select * from products where Lower(name) Like %?1%", nativeQuery = true)
    @Query(value="Select * from products where Lower(name) Like %:query%", nativeQuery = true)
    List<Product> search(String query);

    @Query(value=" Select new com.turkcell.springstarter.services.dtos.product.response.ProductListResponse(p.id, p.name,c.name,p.unitPrice) " +
    "from Product p join p.category c where lower(p.name) like %:query%")
    List<ProductListResponse> serachDto(String query);


    //derived query methods
    List<Product> findByUnitPriceGreaterThan(double unitPrice);

    Optional<Product> findByName(String name);

}
