package com.hm.api;

import java.util.ArrayList;

/**
 * Created by User81 on 14.01.2017.
 */
public class Topic {
    private ArrayList<Post> post = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    public ArrayList<Post> getPost() {
        return post;
    }
    public void setPost(ArrayList<Post> post) {
        this.post = post;
    }
}
