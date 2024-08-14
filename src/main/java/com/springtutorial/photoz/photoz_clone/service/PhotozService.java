package com.springtutorial.photoz.photoz_clone.service;

import com.springtutorial.photoz.photoz_clone.model.Photo;
import com.springtutorial.photoz.photoz_clone.repository.PhotozRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PhotozService {

    @Autowired
    private PhotozRepository photozRepository;

    public Iterable<Photo> get() {
        return photozRepository.findAll();
    }

    public Photo get(Integer id) {
        return photozRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photozRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setFileName(fileName);
        photo.setContentType(contentType);
        photo.setData(data);
        photozRepository.save(photo);
        return photo;
    }
//    private List<Photo> db = List.of(new Photo("1", "hello.jpg"));

}
