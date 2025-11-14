package jrbam.project.bloggingapi;

import jrbam.project.bloggingapi.models.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
