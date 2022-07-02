package com.example.adpostingrestapi.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findByEmail(String username);
}
