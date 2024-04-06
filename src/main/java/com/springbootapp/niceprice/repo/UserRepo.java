package com.springbootapp.niceprice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootapp.niceprice.entity.Product;

public interface UserRepo extends JpaRepository<Product, Integer> {

}
