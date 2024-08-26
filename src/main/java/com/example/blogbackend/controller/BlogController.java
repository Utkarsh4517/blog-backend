package com.example.blogbackend.controller;

import com.example.blogbackend.model.Blog;
import com.example.blogbackend.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable Long id) {
        Optional<Blog> blog = blogService.getBlogById(id);
        // If blog contains a Blog object, ResponseEntity::ok is applied to it, creating a ResponseEntity<Blog> with an HTTP 200 OK status and the Blog object as the body.
        // ResponseEntity.notFound().build() creates a ResponseEntity with an HTTP 404 Not Found status and nobody.
        // .getBody():
        //extracts the body from the ResponseEntity. If blog was present, the body will be the Blog object. If blog was not present, the body will be null.
        return blog.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()).getBody();
    }

    @PostMapping
    public Blog createBlog(@RequestBody Blog blog) {
        return blogService.createOrUpdateBlog(blog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blogDetails) {
        Optional<Blog> blogOptional = blogService.getBlogById(id);
        if(blogOptional.isPresent()) {
            Blog blog = blogOptional.get();
            blog.setTitle(blogDetails.getTitle());
            blog.setContent(blogDetails.getContent());
            blog.setAuthor(blogDetails.getAuthor());
            return ResponseEntity.ok(blogService.createOrUpdateBlog(blog));
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
