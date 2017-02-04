package com.hm.api;

import java.util.UUID;

/**
 * Created by User81 on 14.01.2017.
 */
public class User {

    private String _id;
    private String login;
    private String pass;
    public User () { this._id = UUID.randomUUID().toString(); }

        public User (String login, String pass) {
            this._id = UUID.randomUUID().toString();
            this.login = login;
            this.pass = pass;
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
