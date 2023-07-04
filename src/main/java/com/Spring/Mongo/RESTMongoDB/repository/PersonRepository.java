package com.Spring.Mongo.RESTMongoDB.repository;

import com.Spring.Mongo.RESTMongoDB.collection.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

    @Query(value = "{ 'age' : { $gt : ?0 , $lt : ?1 }}",
        fields = "{ address : 0}"
    )
    List<Person> findPersonByAgeBetween(Integer minAge , Integer maxAge);
}
