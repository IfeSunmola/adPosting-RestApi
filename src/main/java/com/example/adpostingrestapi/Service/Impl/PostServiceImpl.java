package com.example.adpostingrestapi.Service.Impl;

import com.example.adpostingrestapi.Model.Post.Post;
import com.example.adpostingrestapi.Repository.PostRepository;
import com.example.adpostingrestapi.Service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public Post createPost(Post newPost) {

        return null;
    }
}
