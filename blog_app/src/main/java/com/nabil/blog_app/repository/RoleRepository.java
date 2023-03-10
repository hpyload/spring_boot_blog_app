package com.nabil.blog_app.repository;

import com.nabil.blog_app.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author nabil
 * @at 3/10/23 10:37 PM
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
