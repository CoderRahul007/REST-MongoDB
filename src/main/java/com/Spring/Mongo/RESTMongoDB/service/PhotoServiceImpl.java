package com.Spring.Mongo.RESTMongoDB.service;

import com.Spring.Mongo.RESTMongoDB.collection.Photo;
import com.Spring.Mongo.RESTMongoDB.repository.PhotoRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;
    @Override
    public String addPhoto(String originalFilename, MultipartFile image) throws IOException {
        Photo photo = new Photo();
        photo.setTitle(originalFilename);
        photo.setPhoto(new Binary(BsonBinarySubType.BINARY , image.getBytes()));
        return photoRepository.save(photo).getId();

    }

    @Override
    public Photo getPhoto(String id) {
        return photoRepository.findById(id).get();
    }


}