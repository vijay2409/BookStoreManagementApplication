package com.cg.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.bookstore.entities.User;

public interface ILoginRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.email=?1")
	public User findByEmail(String email);

	@Query("select ut from User ut where ut.email=?1 and ut.password=?2")
	public User findByEmailAndPassword(String email, String password);

	@Query("select u from User u where u.email=?1")
	public String deleteByEmail(String email);

}
