package com.test.instagram.Repo;

import com.test.instagram.Model.Post;
import com.test.instagram.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPostRepo extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);
}
