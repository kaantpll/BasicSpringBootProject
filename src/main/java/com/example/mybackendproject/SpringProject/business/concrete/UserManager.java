package com.example.mybackendproject.SpringProject.business.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mybackendproject.SpringProject.business.abstracts.UserService;
import com.example.mybackendproject.SpringProject.core.dataAccess.UserDao;
import com.example.mybackendproject.SpringProject.core.entities.User;
import com.example.mybackendproject.SpringProject.core.utilities.results.DataResult;
import com.example.mybackendproject.SpringProject.core.utilities.results.Result;
import com.example.mybackendproject.SpringProject.core.utilities.results.SuccessDataResult;
import com.example.mybackendproject.SpringProject.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	@Autowired
	private UserManager(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı Eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email));
	
	}

}
