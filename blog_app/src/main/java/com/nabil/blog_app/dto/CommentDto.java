package com.nabil.blog_app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import static com.nabil.blog_app.util.Constants.*;

/**
 * @author nabil
 * @at 3/5/23 10:42 PM
 */
@Setter
@Getter
public class CommentDto {
    private Long id;
    @NotEmpty(message = NOT_EMPTY_NAME)
    private String name;
    @NotEmpty(message = NOT_EMPTY_EMAIL)
    @Email
    private String email;
    @NotEmpty(message = NOT_EMPTY_BODY)
    @Size(min = 10, message = SIZE_BODY)
    private String body;
}
