package com.nabil.blog_app;

import com.nabil.blog_app.entity.Role;
import com.nabil.blog_app.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

@SpringBootApplication
public class BlogAppApplication implements CommandLineRunner {
//    @Autowired
//    private  RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(BlogAppApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
//        Role adminRole = new Role();
//        adminRole.setName("ROLE_ADMIN");
//        roleRepository.save(adminRole);
//
//        Role userRole = new Role();
//        userRole.setName("ROLE_USER");
//        roleRepository.save(userRole);
    }
}
