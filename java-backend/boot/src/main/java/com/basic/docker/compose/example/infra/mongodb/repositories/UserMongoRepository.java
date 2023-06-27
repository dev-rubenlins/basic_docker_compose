package com.basic.docker.compose.example.infra.mongodb.repositories;

import com.basic.docker.compose.example.infra.mongodb.data_model.UserMongoDb;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface UserMongoRepository extends MongoRepository<UserMongoDb, UUID> {

    List<UserMongoDb> findByEmail(String email);

}
