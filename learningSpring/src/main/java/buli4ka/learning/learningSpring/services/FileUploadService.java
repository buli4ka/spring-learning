package buli4ka.learning.learningSpring.services;


import buli4ka.learning.learningSpring.domain.Image;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class FileUploadService {

    public FileUploadService() {


    }

    private List<Image> images = new CopyOnWriteArrayList<>();


    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void addImage(Image image){ images.add(image);}
    public void removeImage(Image image){images.remove(image);}



}
