package com.nabil.blog_app.service.serviceImpl;

import com.nabil.blog_app.dto.LoginDto;
import com.nabil.blog_app.dto.RegisterDto;
import com.nabil.blog_app.entity.Role;
import com.nabil.blog_app.entity.User;
import com.nabil.blog_app.exception.BlogApiException;
import com.nabil.blog_app.exception.ResourceNotFoundException;
import com.nabil.blog_app.repository.RoleRepository;
import com.nabil.blog_app.repository.UserRepository;
import com.nabil.blog_app.security.JwtTokenProvider;
import com.nabil.blog_app.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.nabil.blog_app.util.Constants.*;
import static com.nabil.blog_app.util.Constants.FIELD_NAME;

/**
 * @author nabil
 * @at 3/11/23 4:14 PM
 */
@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(
                        loginDto.getUsernameOrEmail(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        return token;
    }

    @Override
    public String register(RegisterDto registerDto) {
        // Add check for username exists in database
        if(userRepository.existsByUsername(registerDto.getUsername())) {
            throw new BlogApiException(HttpStatus.BAD_REQUEST, USERNAME_EXISTS);
        }
        // Add check for email exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())) {
            throw new BlogApiException(HttpStatus.BAD_REQUEST, EMAIL_EXISTS);
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER").orElseThrow(() -> new ResourceNotFoundException(ROLE_RESOURCE_NAME, FIELD_NAME, "ROLE_USER"));
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
        return "User " + registerDto.getName() + " registered in successfully.";
    }
}
