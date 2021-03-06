package com.example.adpostingrestapi.Post;

import com.example.adpostingrestapi.User.User;
import com.example.adpostingrestapi.User.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserService userService;

//    @Override
//    public Post createPost(PostDto newPostDto) {
//        return new Post(newPostDto);
//    }

    @Override
    public Post createPost(long id, PostDto newPostDto) {
        User userCreatingPost = userService.findById(id);
        newPostDto.setUserWhoPosted(userCreatingPost);
        return postRepository.save(new Post(newPostDto));
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> findPostsByUserId(long id) {
        return postRepository.findByUserId(id);
    }

    @Override
    public Post findPostById(long id) {
                 return postRepository.findById(id)
                .orElseThrow(
                        () -> new PostNotFoundException(id));
    }

    @Override
    public void deletePostById(long id) {
        findPostById(id);// throws exception if not found, below code won't run
        postRepository.deleteById(id);
    }

    @Override
    public Post updatePostById(PostDto newPostDetails, long id) {
        Post postInDb = findPostById(id);

        postInDb.setTitle(newPostDetails.getTitle());
        postInDb.setBody(newPostDetails.getBody());
        postInDb.setCategory(newPostDetails.getPostCategory());
        return postRepository.save(postInDb);
    }
}
