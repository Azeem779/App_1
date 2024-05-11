package com.example.Test.repository;

import com.example.Test.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByUsernameAndPassword(String username, String password);
}
