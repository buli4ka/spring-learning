package buli4ka.learning.learningSpring.domain;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

import java.nio.file.Path;



@Entity
public class Image {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    private Book book;

    private byte[] image;

    //Constuctors
    public Image() {//
    }

    public Image(Long id, Book book, byte[] image) {
        this.id = id;
        this.book = book;
        this.image = image;
    }

    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {

        this.image = image;
    }

//    public void saveImage(MultipartFile image){
//        try {
//            if (image.isEmpty()) {
//                throw new RuntimeException("Failed to store empty file.");
//            }
//            Path destinationFile = this.path.resolve(
//                    Paths.get(image.getOriginalFilename()))
//                    .normalize().toAbsolutePath();
//            if (!destinationFile.getParent().equals(this.path.toAbsolutePath())) {
//                // This is a security check
//                throw new RuntimeException("Cannot store file outside current directory.");
//            }
//            try (InputStream inputStream = image.getInputStream()) {
//                Files.copy(inputStream, destinationFile,
//                        StandardCopyOption.REPLACE_EXISTING);
//            }
//        }
//        catch (IOException e){throw new RuntimeException("Failed to store file.", e);}
//
//    }


}
