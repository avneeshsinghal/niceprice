package com.springbootapp.niceprice.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.springbootapp.niceprice.dto.ProductDTO;
import com.springbootapp.niceprice.dto.ShelfDTO;
import com.springbootapp.niceprice.dto.ShelfDataIngestDTO;
import com.springbootapp.niceprice.dto.UserDTO;
import com.springbootapp.niceprice.dto.ShelfDTO;
import com.springbootapp.niceprice.entity.Product;
import com.springbootapp.niceprice.entity.Shelf;
import com.springbootapp.niceprice.entity.User;
import com.springbootapp.niceprice.entity.Shelf;

@Mapper
public interface  ShelfMapper {
	
	ShelfMapper INSTANCE = Mappers.getMapper(ShelfMapper.class);
	
	ProductDTO  mapShelftoShelfDTO(Product product);
	UserDTO  mapShelftoShelfDTO(User user); 
	
	Product  mapShelfDTOtoShelf(ProductDTO productDTO);
	User  mapShelfDTOtoShelf(UserDTO userDTO); 
	
	Shelf mapShelfDTOtoShelf(ShelfDTO shelfDTO);
	
	ShelfDTO mapShelftoShelfDTO(Shelf shelf);
	

	
	ShelfDataIngestDTO mapShelfDataIngestDTOtoShelfDTO(ShelfDTO shelfDTO);
	ShelfDTO mapShelfDTOtoShelfDataIngestDTO(ShelfDataIngestDTO shelfDataIngestDTO);
	
	
	
	
	
}
