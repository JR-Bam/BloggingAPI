package jrbam.project.bloggingapi.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class BlogPost {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id Long id;

    @Embedded
    private BlogPostContent content;

    private @Temporal(TemporalType.TIMESTAMP) java.util.Date createdAt;
    private @Temporal(TemporalType.TIMESTAMP) java.util.Date updatedAt;

    public BlogPost() {
        this.createdAt = new java.util.Date();
        this.updatedAt = new java.util.Date();
    }

    public BlogPost(BlogPostContent content) {
        this();
        this.content = content;
    }
}
