package xyz.xy718.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.xy718.model.User;
import xyz.xy718.model.UserRole;
import xyz.xy718.repository.UserRepository;
import xyz.xy718.repository.UserRoleRepository;

@Service
public class UserService {

	@Resource
	UserRepository userRepository;
	@Resource
	UserRoleRepository userRoleRepository;
	public Optional<User> getUserByID(int user_id) {
		return userRepository.findById((long) user_id);
	}
	public List<UserRole> getUserRoles(int user_id) {
		return userRoleRepository.findAllByUser_id(user_id);
	}
}
