package com.nabil.blog_app.controller;

import com.nabil.blog_app.dto.CommentDto;
import com.nabil.blog_app.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nabil.blog_app.util.Constants.*;

/**
 * @author nabil
 * @at 3/6/23 10:48 PM
 */
@RestController
@RequestMapping(value = APP_ROOT + PATH_POST_ID)
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(COMMENT_ENDPOINT)
    public ResponseEntity<CommentDto> createComment(@Valid @RequestBody CommentDto commentDto,
                                                    @PathVariable(value = PATH_VARIABLE_POST_ID) Long postId) {
        return new ResponseEntity<>(commentService.createComment(commentDto, postId), HttpStatus.CREATED);
    }

    @GetMapping(COMMENT_ENDPOINT)
    public ResponseEntity<List<CommentDto>> getCommentsByPostId(@PathVariable(value = PATH_VARIABLE_POST_ID) Long postId) {
        return new ResponseEntity<>(commentService.getCommentsByPostId(postId), HttpStatus.OK);
    }

    @GetMapping(PATH_COMMENT_ID)
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = PATH_VARIABLE_POST_ID) Long postId,
                                                     @PathVariable(value = PATH_VARIABLE_COMMENT_ID) Long commentId) {
        return new ResponseEntity<>(commentService.getCommentById(postId, commentId), HttpStatus.OK);
    }

    @PutMapping(PATH_COMMENT_ID)
    public ResponseEntity<CommentDto> updateComment(@Valid @RequestBody CommentDto commentDto,
                                                    @PathVariable(value = PATH_VARIABLE_POST_ID) Long postId,
                                                    @PathVariable(value = PATH_VARIABLE_COMMENT_ID) Long commentId) {

        return new ResponseEntity<>(commentService.updateComment(commentDto, postId, commentId), HttpStatus.OK);
    }

    @DeleteMapping(PATH_COMMENT_ID)
    public ResponseEntity<String> deleteComment(@PathVariable(value = PATH_VARIABLE_POST_ID) Long PostId,
                                                @PathVariable(value = PATH_VARIABLE_COMMENT_ID) Long commentId) {
        commentService.deleteComment(PostId, commentId);
        return new ResponseEntity<>(COMMENT_DELETE_INFO, HttpStatus.OK);
    }
}

