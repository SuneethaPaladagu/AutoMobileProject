package com.nisum.configuration;

import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@RefreshScope
@Import(value = MongoAutoConfiguration.class)
@EnableMongoRepositories("com.nisum.repository")
public class MongoDBConfiguration {
}