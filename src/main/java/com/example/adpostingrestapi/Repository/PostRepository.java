package com.example.adpostingrestapi.Repository;

import com.example.adpostingrestapi.Model.Post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "SELECT p FROM Post p WHERE p.userWhoPosted.id = ?1")
    List<Post> findByUserId(long id);
}
