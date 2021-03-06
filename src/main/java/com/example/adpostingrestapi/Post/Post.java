package com.example.adpostingrestapi.Post;

import com.example.adpostingrestapi.User.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long postId;
    private String title;
    private String body;
    @Enumerated(EnumType.STRING) private PostCategory category;
    private LocalDateTime timePosted;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            updatable = false,
            name = "user_id"
    )
    private User userWhoPosted;

    protected Post(PostDto postDto){
        title = postDto.getTitle();
        body = postDto.getBody();
        timePosted = LocalDateTime.now();
        category = postDto.getPostCategory();
        userWhoPosted = postDto.getUserWhoPosted();
    }
}
