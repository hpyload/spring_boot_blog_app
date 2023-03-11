package com.nabil.blog_app.service;

import com.nabil.blog_app.dto.LoginDto;
import com.nabil.blog_app.dto.RegisterDto;

/**
 * @author nabil
 * @at 3/11/23 4:13 PM
 */
public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto loginDto);
}
