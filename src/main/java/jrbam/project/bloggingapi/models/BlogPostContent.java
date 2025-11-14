package jrbam.project.bloggingapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Embeddable
public class BlogPostContent {
    private @NotEmpty String title;
    private @NotEmpty String content;
    private @NotEmpty String category;
    private @NotNull List<String> tags;
}
