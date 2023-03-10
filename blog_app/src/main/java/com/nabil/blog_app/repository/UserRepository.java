package com.nabil.blog_app.repository;

import com.nabil.blog_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author nabil
 * @at 3/10/23 10:26 PM
 */
public interface UserRepository extends JpaRepository<User, Long> {
Optional <User> findByEmail(String email);
Optional <User> findByUsername(String username);
Optional <User> findByUsernameOrEmail(String username, String email);
Boolean existsByUsername(String username);
Boolean existsByEmail(String email);
}
