package com.nabil.blog_app.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author nabil
 * @at 3/8/23 9:34 PM
 */
@Setter
@Getter
public class CategoryDto {
    // TODO : add validation constraints - JSON ignore - ...
    private Long id;
    private String name;
    private String description;
}
