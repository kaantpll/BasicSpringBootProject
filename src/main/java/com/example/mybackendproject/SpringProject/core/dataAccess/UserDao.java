package com.example.mybackendproject.SpringProject.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mybackendproject.SpringProject.core.entities.User;

public interface UserDao extends JpaRepository<User,Integer> {

	User findByEmail(String email);
	
}
