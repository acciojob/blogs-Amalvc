package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    ImageService imageService1;

    @Autowired
    UserRepository userRepository1;

    public List<Blog> showBlogs(){
        //find all blogs
        List<Blog>list=blogRepository1.findAll();
        return list;

    }

    public void createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        Blog blog=new Blog(title,content);

        //updating the blog details
        User user=userRepository1.findById(userId).get();
        blog.setUser(user);




        //Updating the userInformation and changing its blogs
        List<Blog>list=user.getBlogList();
        list.add(blog);
        user.setBlogList(list);
        blogRepository1.save(blog);
        userRepository1.save(user);

    }

    public Blog findBlogById(int blogId){
        //find a blog
       return blogRepository1.findById(blogId).get();
    }

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it
        Blog blog=blogRepository1.findById(blogId).get();
        Image image=imageService1.createAndReturn(blog,description,dimensions);
        image.setBlog(blog);
        List<Image>list=blog.getImageList();
        if(list==null){
            list=new ArrayList<>();
        }
        list.add(image);
        blog.setImageList(list);
        blogRepository1.save(blog);


    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        if(blogRepository1.findById(blogId).isPresent()){
            blogRepository1.deleteById(blogId);
        }
    }
}
