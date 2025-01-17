package com.springbootapp.niceprice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootapp.niceprice.entity.Product;
import com.springbootapp.niceprice.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findFirstByUserId(String userId);


	
}
