package xyz.xy718.service;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.xy718.model.Role;
import xyz.xy718.repository.RoleRepository;

@Service
public class RoleService {

	@Resource
	RoleRepository repository;
	
	public Optional<Role> getByID(int role_id) {
		return repository.findById((long) role_id);
	}
}
