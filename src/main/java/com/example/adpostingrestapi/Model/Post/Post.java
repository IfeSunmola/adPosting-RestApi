package com.example.adpostingrestapi.Model.Post;

import com.example.adpostingrestapi.Model.User.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long postId;
    private String title;
    private String body;
    @Enumerated(EnumType.STRING) private PostCategory category;
    private LocalDateTime timePosted;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "userId"
    )
    private User userWhoPosted;
}
