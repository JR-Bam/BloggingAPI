package jrbam.project.bloggingapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BlogPostNotFoundAdvice {

    @ExceptionHandler(BlogPostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(BlogPostNotFoundException ex) {
        return ex.getMessage();
    }
}
