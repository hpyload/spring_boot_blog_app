package com.nabil.blog_app.controller;

import com.nabil.blog_app.dto.PostDto;
import com.nabil.blog_app.response.PostResponse;
import com.nabil.blog_app.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.nabil.blog_app.util.Constants.*;

/**
 * @author nabil
 * @at 2/11/23 10:55 PM
 */
@RestController
@RequestMapping(value = APP_ROOT)
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(value = POST_ENDPOINT)
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
//        Assume that we are sending this JSON in the request body, now inside the controller,
//        we can bind JSON Object to Domain Object.
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping(value = POST_ENDPOINT)
    public PostResponse getAllPosts(
            @RequestParam(value = PAGE_NO, defaultValue = DEFAULT_VALUE_PAGE_NO, required = false) int pageNo,
            @RequestParam(value = PAGE_SIZE, defaultValue = DEFAULT_VALUE_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = SORT_BY, defaultValue = DEFAULT_VALUE_SORT_BY, required = false) String sortBy,
            @RequestParam(value = SORT_ORDER, defaultValue = DEFAULT_VALUE_SORT_ORDER, required = false) String sortOrder){
        return new ResponseEntity<>(postService.getAllPosts(pageNo, pageSize,sortBy, sortOrder), HttpStatus.OK).getBody();
//        ResponseEntity represents the whole HTTP response: status code, headers, and body.
    }

    @GetMapping(PATH_POST_ID)
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = PATH_VARIABLE_POST_ID) Long postId){
        return new ResponseEntity<>(postService.getPostById(postId), HttpStatus.OK);
    }

    @PutMapping(PATH_POST_ID)
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,
                                              @PathVariable(name = PATH_VARIABLE_POST_ID) Long postId){
        return new ResponseEntity<>(postService.updatePost(postDto, postId), HttpStatus.OK);
    }

    @DeleteMapping(PATH_POST_ID)
    public ResponseEntity<String> deletePost(@PathVariable(name = PATH_VARIABLE_POST_ID) Long postId){
        postService.deletePost(postId);
        return new ResponseEntity<>(POST_DELETE_INFO, HttpStatus.OK);
    }
}
