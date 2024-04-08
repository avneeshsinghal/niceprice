package com.springbootapp.niceprice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootapp.niceprice.entity.Product;
import com.springbootapp.niceprice.entity.Shelf;
import com.springbootapp.niceprice.entity.ShelfId;
import com.springbootapp.niceprice.entity.User;

public interface ShelfRepo extends JpaRepository<Shelf, ShelfId> {

	
}
