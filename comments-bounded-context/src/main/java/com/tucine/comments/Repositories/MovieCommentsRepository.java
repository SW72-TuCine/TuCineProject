package com.tucine.comments.Repositories;

import com.tucine.comments.Models.MovieComments;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCommentsRepository extends MongoRepository<MovieComments, String> {
}
