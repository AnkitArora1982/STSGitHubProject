package com.synex.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUserName(String userName);
}
