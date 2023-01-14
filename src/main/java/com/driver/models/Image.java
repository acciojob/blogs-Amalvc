package com.driver.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private String dimension;

    @ManyToOne
    @JoinColumn
    private Blog blog;

    public Image(){

    }
    public Image(String description,String dimension){
        this.dimension=dimension;
        this.description=description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public int getId() {
        return id;
    }

    public Blog getBlog() {
        return blog;
    }

    public String getDescription() {
        return description;
    }

    public String getDimension() {
        return dimension;
    }

}

