package com.hm.api;

import java.util.HashSet;

/**
 * Created by User81 on 14.01.2017.
 */
public class UserHolder {
    public static HashSet<User> users = new HashSet<>();

    static {
        users.add(new User("JohnDoe", "12345"));
        users.add(new User("admin","zxcvbn"));
        users.add(new User("E","1337"));
        users.add(new User("Dibil","777"));
        users.add(new User("Andrew","2252"));
    }
    public static User search(String login, String pass) {
        return
                users.stream()
                .filter(user -> user.getLogin().equals(login) && user.getPass().equals(pass))
                .findFirst()
                .orElse(null);
    }
}
