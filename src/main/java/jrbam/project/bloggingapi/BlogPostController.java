package jrbam.project.bloggingapi;

import jakarta.validation.Valid;
import jrbam.project.bloggingapi.models.BlogPost;
import jrbam.project.bloggingapi.models.BlogPostContent;
import jrbam.project.bloggingapi.repos.BlogPostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class BlogPostController {

    private final BlogPostRepository repo;

    public BlogPostController(BlogPostRepository repo) {
        this.repo = repo;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    BlogPost newPost(@Valid @RequestBody BlogPostContent content) {
        return repo.save(new BlogPost(content));
    }

    @PutMapping("/{id}")
    BlogPost updatePost(@Valid @RequestBody BlogPostContent newContent, @PathVariable Long id) {
        return repo.findById(id)
            .map(blogPost -> {
                blogPost.setContent(newContent);
                blogPost.setUpdatedAt(new Date());
                return repo.save(blogPost);
            }).orElseThrow(() -> new BlogPostNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePost(@PathVariable Long id) {
        if (repo.existsById(id))
            repo.deleteById(id);
        else
            throw new BlogPostNotFoundException(id);
    }

    @GetMapping("/{id}")
    BlogPost fetchPost(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new BlogPostNotFoundException(id));
    }

    @GetMapping("")
    List<BlogPost> fetchAllPosts(@RequestParam Optional<String> term) {
        return term.map(repo::searchBlogPostsWithFilter).orElse(repo.findAll());
    }
}
