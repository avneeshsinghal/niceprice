package com.springbootapp.niceprice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootapp.niceprice.dto.ProductDTO;
import com.springbootapp.niceprice.dto.ShelfDTO;
import com.springbootapp.niceprice.dto.UserDTO;
import com.springbootapp.niceprice.entity.Product;
import com.springbootapp.niceprice.entity.Shelf;
import com.springbootapp.niceprice.entity.User;
import com.springbootapp.niceprice.exception.UserAlreadyExistsException;
import com.springbootapp.niceprice.mapper.ProductMapper;
import com.springbootapp.niceprice.mapper.ShelfMapper;
import com.springbootapp.niceprice.mapper.UserMapper;
import com.springbootapp.niceprice.repo.UserRepo;

import jakarta.validation.Valid;

@Service
public class UserService {
	
	static UserRepo userRepo;
	
	UserService(UserRepo userRepo){
		UserService.userRepo = userRepo;
	}

	
	public static UserDTO fetchUserById(String id) {
		Optional<User> user = userRepo.findFirstByUserId(id) ;
		if(user.isPresent()){
			return UserMapper.INSTANCE.mapUsertoUserDTO(user.get());
		}
		return null;
	}


	public UserDTO createUser(UserDTO userDTO) throws UserAlreadyExistsException {
		User addedUser = UserMapper.INSTANCE.mapUserDTOtoUser(userDTO);
		User checkedUser = userRepo.findFirstByUserId(addedUser.getUserId()).orElse(null);
		
		if(checkedUser != null){
	        throw new UserAlreadyExistsException("User already exists with the given User ID.");
	    }
        return UserMapper.INSTANCE.mapUsertoUserDTO(userRepo.save(addedUser));
	}
	



	

	
	
}
