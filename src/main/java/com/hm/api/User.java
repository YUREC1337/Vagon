package com.hm.api;

import java.util.UUID;

/**
 * Created by User81 on 14.01.2017.
 */
public class User {
    private String id;
    private String login;
    private String pass;
    public String getId() {
        return id;
    }

    public User() {
    }
        public User (String login, String pass) {
            this.login = login;
            this.pass = pass;
        }


    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String ligin) {
        this.login = ligin;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
