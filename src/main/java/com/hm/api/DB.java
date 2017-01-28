package com.hm.api;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

/**
 * Created by User81 on 28.01.2017.
 */
public class DB {
//mongodb://<dbuser>:<dbpassword>@ds042459.mlab.com:42459/vagon
    private static final MongoClient client;
    private static final MongoDatabase db;

    static {

        client = new MongoClient(new MongoClientURI("mongodb://test:testtest@ds042459.mlab.com:42459/vagon"));
                db = client.getDatabase("vagon");

    }
    public static  MongoDatabase db(){
        return db;
    }

}
