package com.tucine.comments.Controllers;

import com.tucine.comments.Clients.CinemaClient;
import com.tucine.comments.Models.CineclubComments;
import com.tucine.comments.Services.CineclubCommentsService;
import com.tucine.comments.Clients.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
//cineclub-comments
@RequestMapping("/api/TuCine/v1/comments/cineclub")
public class CineclubCommentsController {
    private final CineclubCommentsService cineclubCommentsService;
    private final UserClient userClient;
    private final CinemaClient cinemaClient;

    @Autowired
    public CineclubCommentsController(UserClient userClient, CinemaClient cinemaClient, CineclubCommentsService cineclubCommentsService) {
        this.cineclubCommentsService = cineclubCommentsService;
        this.userClient = userClient;
        this.cinemaClient = cinemaClient;
    }

    @GetMapping
    public ResponseEntity<List<CineclubComments>> getAllCineclubComments() {
        List<CineclubComments> cineclubComments = cineclubCommentsService.getAllCineclubComments();
        return new ResponseEntity<>(cineclubComments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CineclubComments> getCineclubCommentById(@PathVariable String id) {
        CineclubComments cineclubComment = cineclubCommentsService.getCineclubCommentById(id);
        if (cineclubComment != null) {
            return new ResponseEntity<>(cineclubComment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

/*    @PostMapping
    public ResponseEntity<CineclubComments> createCineclubComment(@RequestBody CineclubComments cineclubComment) {
        CineclubComments createdComment = cineclubCommentsService.createCineclubComment(cineclubComment);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }*/
    @PostMapping
    public ResponseEntity<?> createCineclubComment(@RequestBody CineclubComments cineclubComment) {
        Long userId = cineclubComment.getUserId();
        Long cinemaId = cineclubComment.getCineclubId();

        // Comprueba si el usuario existe llamando al servicio de usuarios
        boolean userExists = userClient.checkIfUserExists(userId);
        boolean cinemaExists = cinemaClient.checkIfCinemaExists(cinemaId);

        if (!userExists) {
            // El usuario no existe, devuelve una respuesta de error
            return new ResponseEntity<>("Usuario no existe", HttpStatus.BAD_REQUEST);

        } else if (!cinemaExists) {
            // El cineclub no existe, devuelve una respuesta de error
            return new ResponseEntity<>("Cineclub no existe", HttpStatus.BAD_REQUEST);

        } else {
            // El usuario existe, procede a crear el comentario de cineclub
            CineclubComments createdComment = cineclubCommentsService.createCineclubComment(cineclubComment);
            return new ResponseEntity<>(createdComment, HttpStatus.CREATED);

        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<CineclubComments> updateCineclubComment(@PathVariable String id, @RequestBody CineclubComments cineclubComment) {
        CineclubComments updatedComment = cineclubCommentsService.updateCineclubComment(id, cineclubComment);
        if (updatedComment != null) {
            return new ResponseEntity<>(updatedComment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCineclubComment(@PathVariable String id) {
        cineclubCommentsService.deleteCineclubComment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
