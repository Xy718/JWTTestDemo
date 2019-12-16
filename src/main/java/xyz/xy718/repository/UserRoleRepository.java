package xyz.xy718.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.xy718.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{

}
