package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Product;
import com.entity.User;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	 @Query(value = "SELECT c FROM Product c WHERE c.date=:keyword")
	    public List<Product> search(@Param("keyword") String keyword);
}
