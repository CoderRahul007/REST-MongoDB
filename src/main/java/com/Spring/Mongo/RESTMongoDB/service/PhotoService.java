package com.Spring.Mongo.RESTMongoDB.service;

import com.Spring.Mongo.RESTMongoDB.collection.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {
    String addPhoto(String originalFilename, MultipartFile image) throws IOException;

    Photo getPhoto(String id);
}
