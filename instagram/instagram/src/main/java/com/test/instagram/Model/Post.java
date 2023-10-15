package com.test.instagram.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;



@Data
@Entity
@NoArgsConstructor
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private String postData;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Post(Timestamp createdDate, Timestamp updatedDate, String postData, User user) {
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.postData = postData;
        this.user = user;
    }
}