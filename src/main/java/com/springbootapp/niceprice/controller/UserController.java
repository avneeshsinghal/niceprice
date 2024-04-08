package com.springbootapp.niceprice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapp.niceprice.dto.UserDTO;
import com.springbootapp.niceprice.exception.UserAlreadyExistsException;
import com.springbootapp.niceprice.service.UserService;

import jakarta.validation.Valid;

@RequestMapping("/user")
@RestController
public class UserController {
	
UserService userService ;
	
	
	UserController(UserService userService){
		this.userService = userService;
	}
	
	@GetMapping("/getUser/{Id}")
	public ResponseEntity<UserDTO> fetchUserById(@PathVariable String Id){
		UserDTO user= UserService.fetchUserById(Id);
		if(user==null) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		return  new ResponseEntity<>(user, HttpStatus.OK); 
	}

	
	@PostMapping("/createUser")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) throws UserAlreadyExistsException{
		UserDTO user = userService.createUser(userDTO) ;
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

}
