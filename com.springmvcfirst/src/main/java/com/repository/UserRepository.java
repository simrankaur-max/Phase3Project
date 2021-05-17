package com.repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	 @Query(value = "SELECT c FROM User c WHERE c.name=:keyword")
	    public List<User> search(@Param("keyword") String keyword);
}