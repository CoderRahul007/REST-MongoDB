package com.Spring.Mongo.RESTMongoDB.service;

import com.Spring.Mongo.RESTMongoDB.collection.Person;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {

    public String save(Person person);

    Page<Person> search(String name, Integer minAge, Integer maxAge, String city, Pageable pageable);

    List<Document> getOldestPersonByCity();

    List<Document>  getPopulationByCity();
}
