package com.controller;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dto.UserDto;
import com.entity.Product;
import com.entity.User;
import com.service.UserService;  

//CREATE DATABASE `sales`;
/*
    CREATE TABLE `user` (
		  `id` int(11) NOT NULL AUTO_INCREMENT,
		  `name` varchar(45) NOT NULL,
		  `email` varchar(45) NOT NULL,
		  `password` varchar(45) NOT NULL,
		  PRIMARY KEY (`id`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8;
		*/

@Controller
public class HelloController {
	
	public HelloController(){
		
	}

	@Autowired 
	private UserService userService;
	
	@RequestMapping("/")
	public String display() {
		User user=new User();
		user.setName("Admin");
		user.setEmail("admin@gmail.com");
		user.setPassword("123456");
		userService.save(user);
		return "index";
	}
	
	 @PostMapping("/login")
	 @ResponseBody
	public ModelAndView validate(@RequestParam("uname") String uname,@RequestParam("password") String password, @RequestParam(required=false) String createdDate, HttpServletRequest request) {
//		Map<String, String> loginObj= (Map<String,String>)loginData;
//		User user=new User("admin","admin@gmail.com", "123456");
		ModelAndView model=new ModelAndView();
//		userService.save(user);
		List<User> userList=null;
		System.out.println("user name is "+uname);
		
		if(uname==null || uname.equals("")) {
			model.setViewName("failedLogin");
			return model;
		}
		else {
			 userList=userService.searchUser(uname);
		}
		
		
		 if(uname.equals("admin") && password.equals("123456")) {
		  HttpSession session = request.getSession();
		  session.setAttribute("user", new User("admin", "email", "password"));
		  userList=userService.listAll();
		  List<Product> products = userService.listAllProducts(); 
		  model.addObject("listUser", userList);
		  model.addObject("listProduct",products);
		  model.addObject("dateFilter","");
		  model.setViewName("admin");
		}
		else if(userList != null && userList.size()>0 && userList.get(0)!=null && uname.equals(userList.get(0).getName()) && password.equals(userList.get(0).getPassword())) {
			model.setViewName("user");
			HttpSession session = request.getSession();
			session.setAttribute("user", userList.get(0));
			System.out.println("constructor of controller user info "+ userList.get(0).getEmail());
		}
		else {
			model.setViewName("failedLogin");
		}
	
		 
		return model;
	}
	 
	 @PostMapping("/jsp/user-register")
	 @ResponseBody
	public ModelAndView register(@RequestParam("uname") String uname,@RequestParam("password") String password, @RequestParam("email") String email) {
//		Map<String, String> loginObj= (Map<String,String>)loginData;
		
		ModelAndView model=new ModelAndView();
		if(uname!=null && !uname.equals("") && password!=null && !password.equals("") && email!=null && !email.equals("")) {
			User user=new User(uname,email, password);
			userService.save(user);
			System.out.println("constructor of controller user info "+ user.getEmail());
			model.setViewName("success");

		}
		else {
			model.setViewName("failedLogin");
		}
		System.out.println("user name is "+uname);
		return model;
	}
	 
	 @PostMapping("/buy-product")
	 @ResponseBody
	public ModelAndView addProduct(@RequestParam("bat") String bat,@RequestParam("football") String football, @RequestParam("ball") String ball, @RequestParam("helmet") String helmet, HttpServletRequest request) {
		 ModelAndView model=new ModelAndView();
		 HttpSession session = request.getSession();
		 User user = (User)session.getAttribute("user");
		 Product product = new Product();
		 product.setBall(ball);
		 product.setBat(bat);
		 product.setFootball(football);
		 product.setHelmet(helmet);
		 product.setUser(user);
		 SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
		 String stringDate= DateFor.format(new Date());
		 product.setDate(stringDate);
		 userService.saveProduct(product);
		 model.addObject("productMsg","Product added successfully");
		 model.setViewName("user");
		 return model;
	}
	 
	 @PostMapping("/product-filter")
	 @ResponseBody
	public ModelAndView setFilter(@RequestParam(required=false) String date) {
		 System.out.println("date object got as "+date);		 
		 ModelAndView model = new ModelAndView();
		  List<User> userList=userService.listAll();
		  List<Product> products = date!=null? userService.searchProduct(date): userService.listAllProducts(); 
		  model.addObject("listUser", userList);
		  model.addObject("listProduct",products);
		  model.addObject("dateFilter",date);
		  model.setViewName("admin");
		 return model;
	 }
}
