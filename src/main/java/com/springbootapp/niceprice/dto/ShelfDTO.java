package com.springbootapp.niceprice.dto;



import com.springbootapp.niceprice.entity.Product;
import com.springbootapp.niceprice.entity.ShelfId;
import com.springbootapp.niceprice.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ShelfDTO {
 
    @EmbeddedId
    private ShelfId id;
 
    private ProductDTO product;
 
    private UserDTO user;
 
    private Double relevancyScore;
    
 
}