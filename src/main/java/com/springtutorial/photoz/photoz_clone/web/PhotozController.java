package com.springtutorial.photoz.photoz_clone.web;

import com.springtutorial.photoz.photoz_clone.model.Photo;
import com.springtutorial.photoz.photoz_clone.service.PhotozService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;

@RestController
public class PhotozController {

    @Autowired
    private PhotozService photozService;

    @GetMapping("/")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/photoz")
    public Collection<Photo> get(){
        return photozService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = photozService.get(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable String id){
        Photo photo = photozService.remove(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/photoz")
    public Photo create(@RequestPart("data")MultipartFile file) throws IOException {
        return photozService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}
