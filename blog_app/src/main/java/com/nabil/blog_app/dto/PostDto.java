package com.nabil.blog_app.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author nabil
 * @at 2/11/23 10:37 PM
 */
@Setter
@Getter
public class PostDto {
    private Long id;
    private String title;
    private String description;
    private String content;
}
