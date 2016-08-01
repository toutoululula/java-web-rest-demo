package com.gl.service;

import java.util.List;

import com.gl.domain.User;

public interface IUserService {
	public User getUserById(int userId);
	public List<User> getAll(int page,int rows,String orderBy);
	public List<User> getAll();
}
