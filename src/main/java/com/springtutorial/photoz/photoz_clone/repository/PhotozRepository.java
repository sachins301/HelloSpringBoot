package com.springtutorial.photoz.photoz_clone.repository;

import com.springtutorial.photoz.photoz_clone.model.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PhotozRepository extends CrudRepository<Photo, Integer> {
}
