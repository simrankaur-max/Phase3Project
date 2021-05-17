package com.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 	private String bat;
    private String ball;
    private String football;
    private String helmet;
    
    @OneToOne
    private User user;
    
    private String date;
    
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBat() {
		return bat;
	}
	public void setBat(String bat) {
		this.bat = bat;
	}
	public String getBall() {
		return ball;
	}
	public void setBall(String ball) {
		this.ball = ball;
	}
	public String getFootball() {
		return football;
	}
	public void setFootball(String football) {
		this.football = football;
	}
	public String getHelmet() {
		return helmet;
	}
	public void setHelmet(String helmet) {
		this.helmet = helmet;
	}
}
