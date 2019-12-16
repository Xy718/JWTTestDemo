package xyz.xy718.service;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.xy718.model.User;
import xyz.xy718.repository.UserRepository;

@Service
public class UserService {

	@Resource
	UserRepository userRepository;
	
	public Optional<User> getUserByID(int user_id) {
		return userRepository.findById((long) user_id);
	}
}
