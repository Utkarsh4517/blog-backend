package com.example.blogbackend.controller;

import com.example.blogbackend.model.Blog;
import com.example.blogbackend.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    // Controller talks with service,
    // Service talks with Repository,
    // Repository talks with db, according to the model.

    @Autowired
    private BlogService blogService;

    @GetMapping // at /api/blogs
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }


}
