package jrbam.project.bloggingapi.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class BlogPost {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "title", column = @Column(name = "content_title")),
            @AttributeOverride( name = "content", column = @Column(name = "content_content")),
            @AttributeOverride( name = "category", column = @Column(name = "content_category")),
            @AttributeOverride( name = "tags", column = @Column(name = "content_tags"))
    })
    private BlogPostContent content;

    private @Temporal(TemporalType.TIMESTAMP) java.util.Date createdAt;
    private @Temporal(TemporalType.TIMESTAMP) java.util.Date updatedAt;

    public BlogPost() {
        this.createdAt = new java.util.Date();
        this.updatedAt = new java.util.Date();
    }
}
