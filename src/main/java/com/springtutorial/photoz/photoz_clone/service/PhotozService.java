package com.springtutorial.photoz.photoz_clone.service;

import com.springtutorial.photoz.photoz_clone.model.Photo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@Service
public class PhotozService {
    private HashMap<String, Photo> db = new HashMap<>(){{
        put("1", new Photo("1", "hello.jpg"));
    }};

    public Collection<Photo> get() {
        return db.values();
    }

    public Photo get(String id) {
        return db.get(id);
    }

    public Photo remove(String id) {
        return db.remove(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setContentType(contentType);
        photo.setData(data);
        db.put(photo.getId(), photo);
        return photo;
    }
//    private List<Photo> db = List.of(new Photo("1", "hello.jpg"));

}
