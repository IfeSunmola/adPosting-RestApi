package com.example.adpostingrestapi.Service;

import com.example.adpostingrestapi.Model.Post.Post;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    Post createPost(Post newPost);
}
