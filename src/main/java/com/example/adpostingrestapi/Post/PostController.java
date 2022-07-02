package com.example.adpostingrestapi.Post;

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

    @PostMapping("/{id}/new")
    public ResponseEntity<Post> createPost(@PathVariable long id, @RequestBody PostDto postDto){
//        Post newPost = postService.createPost(id, postDto);
//        System.out.println(newPost);
        return new ResponseEntity<>(postService.createPost(id, postDto), HttpStatus.OK);
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
