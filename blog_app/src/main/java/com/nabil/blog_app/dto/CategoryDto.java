package com.nabil.blog_app.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import static com.nabil.blog_app.util.Constants.NOT_EMPTY_DESCRIPTION;
import static com.nabil.blog_app.util.Constants.NOT_EMPTY_NAME;

/**
 * @author nabil
 * @at 3/8/23 9:34 PM
 */
@Setter
@Getter
public class CategoryDto {
    // TODO : add validation constraints - JSON ignore - ...
    private Long id;
    @NotEmpty(message = NOT_EMPTY_NAME)
    private String name;
    @NotEmpty(message = NOT_EMPTY_DESCRIPTION)
    private String description;
}
