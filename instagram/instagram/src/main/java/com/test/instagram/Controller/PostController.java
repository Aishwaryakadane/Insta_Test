package com.test.instagram.Controller;

import com.test.instagram.Model.Post;
import com.test.instagram.Service.PostService;
import com.test.instagram.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PostController {

    @Autowired
    PostService postService;


    @Autowired
    TokenService tokenService;

    @PostMapping()
    public ResponseEntity<Void> addPost(@RequestParam String email, @RequestParam String token, @RequestBody Post post) {
        HttpStatus status;
        if(tokenService.authenticate(email,token))
        {
            postService.addPost(post);
            status = HttpStatus.OK;
        }
        else
        {
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<Void>(status);

    }

    @GetMapping()
    public ResponseEntity<List<Post>> getAllPost(@RequestParam String email, @RequestParam String token) {
        HttpStatus status;
        List<Post> postList = null;
        if(tokenService.authenticate(email,token))
        {

            postList =  postService.getAllPosts(token);
            status = HttpStatus.OK;
        }
        else
        {
            status = HttpStatus.FORBIDDEN;
        }



        return new ResponseEntity<List<Post>>(postList, status);
    }
}