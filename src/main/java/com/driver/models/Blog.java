package com.driver.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Blog{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String title;

    private String content;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date pubDate;

    @ManyToOne
    @JoinColumn
    private User user;

    public Blog(){

    }
    public Blog(String title,String content){
        this.title=title;
        this.content=content;
    }

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    private List<Image> imageList;
    public void setContent(String content) {
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getPubDate() {
        return pubDate;
    }



    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }
}
