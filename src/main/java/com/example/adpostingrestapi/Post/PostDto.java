package com.example.adpostingrestapi.Post;

import com.example.adpostingrestapi.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PostDto {
    private String title;
    private String body;
    private PostCategory postCategory;
    private User userWhoPosted;
}
