package com.springbootapp.niceprice.entity;

import java.util.Objects;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Shelf")
@Table(name = "shelf")
@AllArgsConstructor
@NoArgsConstructor
@Data
@NaturalIdCache
@Cache(
    usage = CacheConcurrencyStrategy.READ_WRITE
)
public class Shelf {
 
    @EmbeddedId
    private ShelfId id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    private Product product;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;
 
    @Column(name = "relevancy_score")
    private Double relevancyScore;
 
   
 
    public Shelf(Product product, User user,Double relevancyScore) {
        this.product = product;
        this.user = user;
        this.relevancyScore = relevancyScore;
        this.id = new ShelfId(product.getProductId(), user.getUserId());
    }
 

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        Shelf that = (Shelf) o;
        return Objects.equals(product, that.product) &&
               Objects.equals(user, that.user);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(product, user);
    }
}