package com.springbootapp.niceprice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.springbootapp.niceprice.dto.ProductDTO;
import com.springbootapp.niceprice.entity.Product;

@Mapper
public interface  ProductMapper {
	
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
	Product mapProductDTOtoProduct(ProductDTO productDTO);
	
	ProductDTO mapProducttoProductDTO(Product product);
}
