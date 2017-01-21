package com.hm.api;

/**
 * Created by User81 on 14.01.2017.
 */
public class Post {
    private String message;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
