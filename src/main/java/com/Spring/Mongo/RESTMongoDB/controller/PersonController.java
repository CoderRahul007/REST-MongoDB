package com.Spring.Mongo.RESTMongoDB.controller;

import com.Spring.Mongo.RESTMongoDB.collection.Person;
import com.Spring.Mongo.RESTMongoDB.service.PersonService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.System.out;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public  String savePerson(Person person){
        return personService.save(person);
    }

    @GetMapping("/search")
    public Page<Person> searchPerson(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) Integer minAge,
        @RequestParam(required = false) Integer maxAge,
        @RequestParam(required = false) String city,
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) Integer size
    ){
        Pageable pageable = PageRequest.of(page , size);
        return  personService.search(name , minAge , maxAge , city , pageable);
    }

    @GetMapping("/oldestPerson")
    public List<Document> getOldestPerson(){
        return personService.getOldestPersonByCity();
    }

    @GetMapping("/populationByCity")
    public List<Document> getPopulationByCity(){
        return personService.getPopulationByCity();
    }
}
