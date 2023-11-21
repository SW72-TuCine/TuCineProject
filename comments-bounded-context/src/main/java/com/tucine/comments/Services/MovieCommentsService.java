package com.tucine.comments.Services;

import com.tucine.comments.Models.MovieComments;

import java.util.List;

public interface MovieCommentsService {
    List<MovieComments> getAllMovieComments();

    MovieComments getMovieCommentById(String id);

    MovieComments createMovieComment(MovieComments movieComment);

    MovieComments updateMovieComment(String id, MovieComments movieComment);

    void deleteMovieComment(String id);
}
