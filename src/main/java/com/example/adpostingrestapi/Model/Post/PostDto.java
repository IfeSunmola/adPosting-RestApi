package com.example.adpostingrestapi.Model.Post;

import com.example.adpostingrestapi.Model.User.User;
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
