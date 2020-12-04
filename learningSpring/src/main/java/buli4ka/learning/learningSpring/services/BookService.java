package buli4ka.learning.learningSpring.services;


import buli4ka.learning.learningSpring.domain.Author;
import buli4ka.learning.learningSpring.domain.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class BookService {


    private List<Book> bookList = new CopyOnWriteArrayList<>();



    public void addBook(Book book){
        bookList.add(book);
    }
    public void deleteBook(Book book){
        bookList.remove(book);
    }

    //return All Books
    public List<Book> getBooks(){
        return bookList;
    }
    //return 1 Book by id
    public Book getBook(Long id) {

        return bookList.stream().filter(i -> i.getId().equals(id)).findFirst().get();
    }

    // Change Book in List
    public Book updateBook (Long id, Book book){
        bookList.stream().forEach(i->{if( i.getId().equals(id)){
        i.setTitle(book.getTitle());
        i.setIsbn(book.getIsbn());
        i.setPublisher(book.getPublisher());
        i.setAuthors(book.getAuthors());
        }
        });
        return bookList.stream().filter(i->i.getId().equals(id)).findFirst().get();
    }


    //Looking for books with given Author
    public List<Book> getSortedByAuthor(Author author){
        List<Book> sortedBooks = new ArrayList<>();
        for (var i:bookList )
            for (var j:i.getAuthors())
                if(j == author && !sortedBooks.contains(i))
                    sortedBooks.add(i);
        return sortedBooks;
    }

}
