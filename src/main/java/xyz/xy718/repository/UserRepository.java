package xyz.xy718.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.xy718.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserNameOrEmail(String username, String email);

    User findByUserName(String username);

}