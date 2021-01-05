package com.example.demo;

import com.mongodb.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {

    MongoClient mongoClient;
    DB database;
    DBCollection collection;


    @GetMapping("/currexg/from/{from}/to/{to}")
    public ExchangeVal getInventoryDetails(@PathVariable("from") Currencies from, @PathVariable("to") Currencies to) {
        ExchangeVal exgVal = null;

        initialAndPopulateDB();

        DBObject query = new BasicDBObject("_id", from);
        DBCursor cursor = collection.find(query);

        DBObject jo = cursor.one();

        System.out.println((String)cursor.one().get("rate"));


        if (Currencies.USD == from && Currencies.ILS == to) {
            exgVal = new ExchangeVal(901, from, to, 6);
        } else if (Currencies.USD == from && Currencies.YEN == to) {
            exgVal = new ExchangeVal(902, from, to, 2);
        }
            return exgVal;
        }

    private void initialAndPopulateDB() {
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        database = mongoClient.getDB("example");
        collection = database.getCollection("currencies");

        collection.insert(new BasicDBObject("_id", "USD").append("rate", "1"));
        collection.insert(new BasicDBObject("_id", "ILS").append("rate", "3.203"));
        collection.insert(new BasicDBObject("_id", "EUR").append("rate", "0.813"));
        collection.insert(new BasicDBObject("_id", "GBP").append("rate", "0.734"));
        collection.insert(new BasicDBObject("_id", "INR").append("rate", "73.126"));
    }
}
