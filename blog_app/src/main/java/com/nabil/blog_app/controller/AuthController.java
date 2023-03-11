package com.nabil.blog_app.controller;

import com.nabil.blog_app.dto.LoginDto;
import com.nabil.blog_app.dto.RegisterDto;
import com.nabil.blog_app.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.nabil.blog_app.util.Constants.*;

/**
 * @author nabil
 * @at 3/11/23 4:27 PM
 */

@RestController
@RequestMapping(APP_ROOT)
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping({LOGIN_ENDPOINT, SIGNIN_ENDPOINT})
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        return new ResponseEntity<>(authService.login(loginDto), HttpStatus.OK);
    }

    @PostMapping({REGISTER_ENDPOINT, SIGNUP_ENDPOINT})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        return new ResponseEntity<>(authService.register(registerDto), HttpStatus.CREATED);
    }
}
