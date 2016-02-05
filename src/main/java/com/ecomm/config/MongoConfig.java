package com.ecomm.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Created by Silviu on 2/4/16.
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "ecomm-db";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("vps.silviu-s.com", 27017);
    }

}
