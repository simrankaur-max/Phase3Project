package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Product;
import com.entity.User;
import com.repository.ProductRepository;
import com.repository.UserRepository;
@Service
@Transactional
public class UserService {
	 @Autowired
	 UserRepository repo;
	 
	 @Autowired
	 ProductRepository productRepo;
     
	    public void save(User customer) {
	        repo.save(customer);
	    }
	     
	    public List<User> listAll() {
	        return (List<User>) repo.findAll();
	    }
	     
	    public UserService() {
			super();
//			User user=new User("admin","admin@gmail.com" ,"123456");
//			repo.save(user);
			// TODO Auto-generated constructor stub
		}
	    
	    public List<User> searchUser(String keyword){
	    	List<User> users= repo.search(keyword);
	    	return users;
	    }

		public User get(Long id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(Long id) {
	        repo.deleteById(id);
	    }
	    
	    public List<Product> listAllProducts(){
	     return (List<Product>)productRepo.findAll();
	    }
	    
	    public void saveProduct(Product product) {
	        productRepo.save(product);
	    }
	    
	    public List<Product> searchProduct(String keyword){
	    	List<Product> products= productRepo.search(keyword);
	    	return products;
	    }
}
