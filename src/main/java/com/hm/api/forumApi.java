package com.hm.api;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;


@RestController
@RequestMapping("/forum")
public class forumApi {
    public static HashSet<Topic> topics = new HashSet<>();
    @RequestMapping("/login")
    public ResponseEntity login (@RequestParam("login") String login, @RequestParam("pass") String pass) {
        return ResponseEntity.ok(UserHolder.search(login, pass));
    }
    @RequestMapping("/createTopic")
    public ResponseEntity createForum (@RequestParam("neme") String name){
        Topic topic = new Topic();
        topic.setName(name);
        topics.add(topic);
        return ResponseEntity.ok(topic);
    }
    @RequestMapping("/getTopics")
    public Set<Topic> getToics(){
        return topics;
    }
    @RequestMapping("/getTopic/{name}")
    public ResponseEntity getTopic (@PathVariable("name") String name) {
        return ResponseEntity
                .ok(topics.stream()
                        .filter(x -> x.getName().equals(name))
                        .findFirst()
                        .orElse(null)
                );
    }
}
