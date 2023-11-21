package com.tucine.comments.Repositories;

import com.tucine.comments.Models.CineclubComments;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CineclubCommentsRepository extends MongoRepository<CineclubComments, String> {
}
