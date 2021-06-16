package com.example.mybackendproject.SpringProject.business.abstracts;

import com.example.mybackendproject.SpringProject.core.entities.User;
import com.example.mybackendproject.SpringProject.core.utilities.results.DataResult;
import com.example.mybackendproject.SpringProject.core.utilities.results.Result;

public interface UserService {

	
	Result add(User user);
	DataResult<User> findByEmail(String email);
}
