package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;
    @Autowired
    private BlogRepository blogRepository;

    public Image createAndReturn(Blog blog, String description, String dimensions){
        //create an image based on given parameters and add it to the imageList of given blog
        Image image=new Image(description,dimensions);
        image.setBlog(blog);

        List<Image> list=blog.getImageList();
        if(list==null){
            list=new ArrayList<>();
        }
        list.add(image);
        blog.setImageList(list);
        blogRepository.save(blog);
        return image;
    }

    public void deleteImage(Image image){
        if(imageRepository2.findById(image.getId()).isPresent()){
            imageRepository2.deleteById(image.getId());
        }

    }

    public Image findById(int id) {
        if(imageRepository2.findById(id).isPresent())
            return imageRepository2.findById(id).get();
        return null;
    }

    public int countImagesInScreen(Image image, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        //In case the image is null, return 0
        if(screenDimensions.split("X").length==2|| Objects.nonNull(image)){
            Integer maxlen=Integer.parseInt(screenDimensions.split("X")[0])/Integer.parseInt(image.getDimensions().split("X")[0]);
            Integer maxbred=Integer.parseInt(screenDimensions.split("X")[1])/Integer.parseInt(image.getDimensions().split("X")[1]);
            return maxbred*maxlen;
        }
        return 0;


    }
}
