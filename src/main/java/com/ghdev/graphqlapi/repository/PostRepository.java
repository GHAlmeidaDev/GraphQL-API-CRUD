package com.ghdev.graphqlapi.repository;

import com.ghdev.graphqlapi.model.Post;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, ObjectId> {

}
