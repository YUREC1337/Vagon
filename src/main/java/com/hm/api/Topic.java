package com.hm.api;

import java.util.ArrayList;

/**
 * Created by User81 on 14.01.2017.
 */
public class Topic {
    private ArrayList<String> post = new ArrayList<>();
    public ArrayList<String> getPost() {
        return post;
    }
    public void setPost(ArrayList<String> post) {
        this.post = post;
    }
}
