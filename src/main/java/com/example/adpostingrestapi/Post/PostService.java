package com.example.adpostingrestapi.Post;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    Post createPost(PostDto newPostDto);
    List<Post> findAllPosts();
    List<Post> findPostsByUserId(long id);
    Post findPostById(long id);
    Post updatePostById(PostDto newPostDetails, long id);
    void deletePostById(long id);
}
