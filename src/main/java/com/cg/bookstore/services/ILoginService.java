package com.cg.bookstore.services;

import com.cg.bookstore.entities.User;

public interface ILoginService {

	public User addUser(User user);

	public String removeUser(String email);

	public User validateLogin(User user);
}
