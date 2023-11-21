package com.tucine.comments.Services;

import com.tucine.comments.Models.CineclubComments;

import java.util.List;

public interface CineclubCommentsService {
    List<CineclubComments> getAllCineclubComments();

    CineclubComments getCineclubCommentById(String id);

    CineclubComments createCineclubComment(CineclubComments cineclubComment);

    CineclubComments updateCineclubComment(String id, CineclubComments cineclubComment);

    void deleteCineclubComment(String id);

}
