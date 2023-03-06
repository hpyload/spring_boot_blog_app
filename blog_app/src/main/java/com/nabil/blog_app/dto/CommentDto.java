package com.nabil.blog_app.dto;

import com.nabil.blog_app.entity.Post;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * @author nabil
 * @at 3/5/23 10:42 PM
 */
@Setter
@Getter
public class CommentDto {
    private Long id;
    private String name;
    private String email;
    private String body;
}
