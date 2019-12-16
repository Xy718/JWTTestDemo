package xyz.xy718.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.xy718.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameOrEmail(String username, String email);

    User findByUsername(String username);

    
}