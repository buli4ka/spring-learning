package buli4ka.learning.learningSpring.repositories;

import buli4ka.learning.learningSpring.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {


}
