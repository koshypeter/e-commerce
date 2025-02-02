package com.example.ecommerce.Products;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductModel,Integer> {
}
