package com.employee.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employee.model.UserRepo;
import com.employee.model.Users;

@Service
public class CurrentUser implements UserDetailsService {
	@Autowired
	UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Users> user = repo.findByUsername(username);
		if (user.isEmpty()) {
			throw new UsernameNotFoundException("User not Found");
		}

		return user.get();
	}

}
