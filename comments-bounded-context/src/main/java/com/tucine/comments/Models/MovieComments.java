package com.tucine.comments.Models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "movie_comments")
@EqualsAndHashCode(callSuper = true)
public class MovieComments extends Comment {
    @Field("movie_name")
    private String movie;

    private Long movieId;

    private List<Comment> replies;

}
