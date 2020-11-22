package buli4ka.learning.learningSpring.bootstrap;

import buli4ka.learning.learningSpring.domain.Author;
import buli4ka.learning.learningSpring.domain.Book;
import buli4ka.learning.learningSpring.domain.Publisher;
import buli4ka.learning.learningSpring.repositories.AuthorRepository;
import buli4ka.learning.learningSpring.repositories.BookRepository;
import buli4ka.learning.learningSpring.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Srarted in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Publisher");
        publisher.setCity("Kiev");

        publisherRepository.save(publisher);
        System.out.println("Publisher count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book coolBook = new Book("Programming", "38715687974");

        eric.getBooks().add(coolBook);
        coolBook.getAuthors().add(eric);

        coolBook.setPublisher(publisher);
        publisher.getBooks().add(coolBook);

        authorRepository.save(eric);
        bookRepository.save(coolBook);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book coolRods = new Book("Development", "6414348613216");
        rod.getBooks().add(coolRods);
        coolRods.getAuthors().add(rod);

        coolRods.setPublisher(publisher);
        publisher.getBooks().add(coolRods);

        authorRepository.save(rod);
        bookRepository.save(coolRods);
        publisherRepository.save(publisher);

        System.out.println("Number of books:" + bookRepository.count());
        System.out.println("Publisher number of books: " + publisher.getBooks().size());
    }
}
