package com.example.adpostingrestapi.Controller;

import com.example.adpostingrestapi.Model.Post.Post;
import com.example.adpostingrestapi.Model.Post.PostDto;
import com.example.adpostingrestapi.Service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/all")
    public List<Post> findAllPosts() {
        return postService.findAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable long id) {
        return new ResponseEntity<>(postService.findPostById(id), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Post> createPost(@RequestBody PostDto newPostDto) {
        return new ResponseEntity<>(postService.createPost(newPostDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Post> updatePost(@RequestBody PostDto newPostDetails, @PathVariable long id) {
        return new ResponseEntity<>(postService.updatePostById(newPostDetails, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> deletePost(@PathVariable long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Post successfully deleted", HttpStatus.OK);
    }
}
