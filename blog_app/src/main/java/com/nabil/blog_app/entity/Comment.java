package com.nabil.blog_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nabil
 * @at 3/5/23 9:04 PM
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "body", nullable = false)
    private String body;
    @ManyToOne(fetch = FetchType.LAZY)
    //fetch = FetchType.LAZY means that the associated entity should not be loaded eagerly with the source entity,
    // but instead should be loaded lazily on demand when it is actually accessed.
    //default fetch type FetchType.EAGER
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
}
