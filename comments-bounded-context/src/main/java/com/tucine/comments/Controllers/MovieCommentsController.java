package com.tucine.comments.Controllers;

import com.tucine.comments.Clients.MovieClient;
import com.tucine.comments.Clients.UserClient;
import com.tucine.comments.Models.MovieComments;
import com.tucine.comments.Services.MovieCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/TuCine/v1/comments/movie")
public class MovieCommentsController {
    private final MovieCommentsService movieCommentsService;
    private final UserClient userClient;
    private final MovieClient movieClient;

    @Autowired
    public MovieCommentsController(UserClient userClient, MovieClient movieClient, MovieCommentsService movieCommentsService) {
        this.movieCommentsService = movieCommentsService;
        this.userClient = userClient;
        this.movieClient = movieClient;
    }

    @GetMapping
    public ResponseEntity<List<MovieComments>> getAllMovieComments() {
        List<MovieComments> movieComments = movieCommentsService.getAllMovieComments();
        return new ResponseEntity<>(movieComments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieComments> getMovieCommentById(@PathVariable String id) {
        MovieComments movieComment = movieCommentsService.getMovieCommentById(id);
        if (movieComment != null) {
            return new ResponseEntity<>(movieComment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createMovieComment(@RequestBody MovieComments movieComment) {
        Long userId = movieComment.getUserId();
        Long movieId = movieComment.getMovieId();
        // Comprueba si el usuario existe llamando al servicio de usuarios
        boolean userExists = userClient.checkIfUserExists(userId);
        boolean movieExists = movieClient.checkIfMovieExists(movieId);

        if(!userExists){
            return new ResponseEntity<>("Usuario no existe", HttpStatus.BAD_REQUEST);

        } else if (!movieExists){
            return new ResponseEntity<>("Película no existe", HttpStatus.BAD_REQUEST);
        } else {
            MovieComments createdComment = movieCommentsService.createMovieComment(movieComment);
            return new ResponseEntity<>(createdComment, HttpStatus.CREATED);

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieComments> updateMovieComment(@PathVariable String id, @RequestBody MovieComments movieComment) {
        MovieComments updatedComment = movieCommentsService.updateMovieComment(id, movieComment);
        if (updatedComment != null) {
            return new ResponseEntity<>(updatedComment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieComment(@PathVariable String id) {
        movieCommentsService.deleteMovieComment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
