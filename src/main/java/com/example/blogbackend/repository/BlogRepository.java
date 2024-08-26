package com.example.blogbackend.repository;

import com.example.blogbackend.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    // Any additional queries if needed.
    // JPA Provides basic crud by default
}
