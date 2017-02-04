package com.hm.api;

import com.google.gson.Gson;
import org.bson.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import static com.hm.api.DB.db;


@RestController
@RequestMapping("/forum")
public class forumApi {
    public static HashMap<String, Topic> topics = new HashMap<>();

    @RequestMapping("/login")
    public User login(@RequestParam("login") String login, @RequestParam("pass") String pass) {
        User user = new Gson().fromJson(
                db().getCollection("user")
                        .find(Document.parse("{'login':'"+ login + " , 'pass':'" + pass + "'}"))
                        .first()
                        .toJson(),
                User.class

        );
        return user;
    }




    @RequestMapping("/createTopic")
    public ResponseEntity createTopic(@RequestParam("name") String name) {
        Topic topic = new Topic();
        topic.setName(name);
        topics.put(name, topic);
        return ResponseEntity.ok(topic);
    }

    @RequestMapping({"/getTopics", "/getForums"})
    public Collection<Topic> getTopics() {
        return topics.values();
    }

    @RequestMapping("/getTopic/{name}")
    public ResponseEntity getTopic(@PathVariable("name") String name) {
        return ResponseEntity.ok(topics.get(name));
    }

    @RequestMapping(value = "/post/{mame}", method = RequestMethod.POST)
    public ResponseEntity post(@PathVariable("mame") String name,
                               @RequestParam("text") String text,
                               @RequestParam("login") String login,
                               @RequestParam("pass") String pass) {
        User user = login (login, pass);
        if (user == null) {
            return ResponseEntity.status(403).body("WRONG PASSWORD");
        }
        Post post = new Post();
        post.setMessage(text);
        post.setUserLogin(user.getLogin());
        topics.get(name).getPost().add(post);
        return getTopic(name);
    }
}

