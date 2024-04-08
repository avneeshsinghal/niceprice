package com.springbootapp.niceprice.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ShelfId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "product_id")
	   private String productId;
	 
    @Column(name = "user_id")
    private String userId;
        
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        ShelfId that = (ShelfId) o;
        return Objects.equals(productId, that.productId) &&
               Objects.equals(userId, that.userId);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(productId, userId);
    }
    
}

