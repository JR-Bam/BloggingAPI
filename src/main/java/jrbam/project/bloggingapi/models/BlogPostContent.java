package jrbam.project.bloggingapi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Embeddable
public class BlogPostContent {

    private String title;
    private String content;
    private String category;
    private List<String> tags;
}
