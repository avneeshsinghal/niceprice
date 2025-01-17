package com.springbootapp.niceprice.repo;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootapp.niceprice.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

	Optional<Product> findFirstByProductId(String productId);

	Boolean existsByProductId(String productId);

}
