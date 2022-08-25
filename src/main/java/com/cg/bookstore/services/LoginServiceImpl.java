package com.cg.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entities.User;
import com.cg.bookstore.exceptions.UserNotPresentException;
import com.cg.bookstore.repository.ILoginRepository;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private ILoginRepository loginRepository;

	@Override
	public User validateLogin(User user) {
		if (user != null) {
			User findByEmail = loginRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
			if (findByEmail != null) {
				return findByEmail;
			} else {
				throw new UserNotPresentException("User not Present");
			}
		} else {
			return null;
		}
	}

	@Override
	public User addUser(User user) {
		return loginRepository.save(user);
	}

	@Override
	public String removeUser(String email) {
		return loginRepository.deleteByEmail(email);
	}

}
