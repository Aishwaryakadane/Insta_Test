package com.test.instagram.Service;

import com.test.instagram.Model.Post;
import com.test.instagram.Model.User;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.time.LocalTime.now;

@Service
public class PostService {

    @Autowired
    IPostRepos postRepository;

    @Autowired
    ITokenRepo tokenRepository;

    public void addPost(Post post) {
        postRepository.save(post);
    }

    //list of post
    public List<Post> getAllPosts(String token) {
        User user = tokenRepository.findFirstByToken(token).getUser();
        List<Post> posts = postRepository.findByUser(user);
        return posts;
    }
}