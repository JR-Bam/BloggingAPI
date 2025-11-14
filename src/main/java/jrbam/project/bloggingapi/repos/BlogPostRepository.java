package jrbam.project.bloggingapi.repos;

import jrbam.project.bloggingapi.models.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    @Query("SELECT b FROM BlogPost b WHERE " +
            "UPPER(b.content.content) LIKE UPPER(CONCAT('%', ?1, '%')) OR " +
            "UPPER(b.content.title) LIKE UPPER(CONCAT('%', ?1, '%')) OR " +
            "UPPER(b.content.category) LIKE UPPER(CONCAT('%', ?1, '%'))")
    List<BlogPost> searchBlogPostsWithFilter(String term);
}
