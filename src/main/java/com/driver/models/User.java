package com.driver.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = false)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    public User(){

    }
    public User(String username,String password,String firstName,String lastName){
        this.username=username;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastName;
    }
    @OneToMany
    @JoinColumn
    private Blog blog;

    public int getId() {
        return id;
    }

    public Blog getBlog() {
        return blog;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Blog> blogList;
    public List<Blog> getBlogList(){
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}
