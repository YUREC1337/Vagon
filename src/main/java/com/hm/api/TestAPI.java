package com.hm.api;

import com.google.gson.Gson;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

import static com.hm.api.DB.db;


@RestController
@RequestMapping("/test")
public class TestAPI {


	public static HashSet<User> users = new HashSet<>();

	static {
		users.add(new User("JohnDoe", "12345"));
		users.add(new User("admin","zxcvbn"));
		users.add(new User("E","1337"));
		users.add(new User("Dibil","777"));
		users.add(new User("Andrew","2252"));
	}

	@RequestMapping("/test")
	public String testUser() {
		return "test";
	}

@RequestMapping("/createDB")
	public String createDB() {
	db().drop();
	db().createCollection("user");
	db().getCollection("user").insertOne(Document.parse(new Gson().toJson(new User("JohnDoe","123456"))));
	db().getCollection("user").insertOne(Document.parse(new Gson().toJson(new User("admin","zxcvbn"))));
	db().getCollection("user").insertOne(Document.parse(new Gson().toJson(new User("E","1337"))));
	db().getCollection("user").insertOne(Document.parse(new Gson().toJson(new User("Dibil","777"))));
	db().getCollection("user").insertOne(Document.parse(new Gson().toJson(new User("Andrew","2252"))));
	return db().getCollection("user").find().toString();
}

}
