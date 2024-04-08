package com.springbootapp.niceprice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.springbootapp.niceprice.dto.ProductDTO;
import com.springbootapp.niceprice.dto.UserDTO;
import com.springbootapp.niceprice.entity.Product;
import com.springbootapp.niceprice.entity.User;

@Mapper
public interface  UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	User mapUserDTOtoUser(UserDTO userDTO);
	
	UserDTO mapUsertoUserDTO(User user);
}
