package buli4ka.learning.learningSpring.repositories;

import buli4ka.learning.learningSpring.domain.Book;
import buli4ka.learning.learningSpring.domain.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image,Long> {


}