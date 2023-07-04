package com.Spring.Mongo.RESTMongoDB.repository;

import com.Spring.Mongo.RESTMongoDB.collection.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo , String> {
}
