package com.springbootapp.niceprice.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.springbootapp.niceprice.dto.ProductDTO;
import com.springbootapp.niceprice.dto.ShelfDTO;
import com.springbootapp.niceprice.entity.Product;
import com.springbootapp.niceprice.entity.Shelf;

@Mapper
public interface  ProductMapper {
	
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
	Set<ShelfDTO> mapProducttoProductDTO(Set<Shelf> user);
	
	Product mapProductDTOtoProduct(ProductDTO productDTO);
	
	ProductDTO mapProducttoProductDTO(Product product);
	
	
}
