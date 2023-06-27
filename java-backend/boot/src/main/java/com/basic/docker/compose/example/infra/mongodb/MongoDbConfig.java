package com.basic.docker.compose.example.infra.mongodb;

import com.basic.docker.compose.example.adapters.gateways.UserGatewayMongo;
import com.basic.docker.compose.example.adapters.mappers.UserMongoDbMapper;
import com.basic.docker.compose.example.entities.UserFactory;
import com.basic.docker.compose.example.infra.mongodb.data_model.UserMongoDb;
import com.basic.docker.compose.example.infra.mongodb.repositories.UserMongoRepository;
import com.basic.docker.compose.example.use_cases.UserGateway;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.UuidRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.UUID;

@Configuration
@EnableMongoRepositories(basePackages = "com.basic.docker.compose.example.infra.mongodb.repositories")
public class MongoDbConfig {

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private String port;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.username}")
    private String username;

    @Value("${spring.data.mongodb.password}")
    private String password;

    private ConnectionString mongoConnectionString() {
        return new ConnectionString("mongodb://"+username+":"+password+"@"+host+":"+port+"/"+database);
    }

    @Bean
    public MongoClient mongo(){
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(mongoConnectionString())
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public UserMongoDbMapper userMongoDbMapper(UserFactory userFactory){
        return new UserMongoDbMapper(userFactory);
    }

    @Bean
    public UserGateway userGateway(UserMongoRepository userRepository, UserFactory userFactory){
        return new UserGatewayMongo(userRepository, userMongoDbMapper(userFactory));
    }

    @Bean
    CommandLineRunner commandLineRunner(UserMongoRepository userRepository) {
        return strings -> {
            if (userRepository.count() == 0){
                userRepository.save(new UserMongoDb(UUID.randomUUID(), "peter@mail.com", "123456"));
                userRepository.save(new UserMongoDb(UUID.randomUUID(), "sam@mail.com", "123456"));
            }
        };
    }
}
