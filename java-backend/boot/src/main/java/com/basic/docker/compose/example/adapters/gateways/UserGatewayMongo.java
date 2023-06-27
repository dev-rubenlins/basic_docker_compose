package com.basic.docker.compose.example.adapters.gateways;

import com.basic.docker.compose.example.adapters.mappers.UserMongoDbMapper;
import com.basic.docker.compose.example.entities.User;
import com.basic.docker.compose.example.infra.mongodb.data_model.UserMongoDb;
import com.basic.docker.compose.example.infra.mongodb.repositories.UserMongoRepository;
import com.basic.docker.compose.example.use_cases.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserGatewayMongo implements UserGateway {

    private final UserMongoRepository mongoRepo;
    private final UserMongoDbMapper mongoMapper;

    @Autowired
    public UserGatewayMongo(UserMongoRepository mongoRepo, UserMongoDbMapper mongoMapper) {
        this.mongoRepo = mongoRepo;
        this.mongoMapper = mongoMapper;
    }

    @Override
    public boolean userExists(String email) {
        List<UserMongoDb> users = mongoRepo.findByEmail(email);
        return !users.isEmpty();
    }

    @Override
    public void save(User user) {
        mongoRepo.save(mongoMapper.toDataModel(user));
    }

    public Optional<User> findById(UUID userId){
        Optional<UserMongoDb> optUserMongo = mongoRepo.findById(userId);
        return optUserMongo.isPresent() ?
                Optional.of(mongoMapper.toDomainModel(optUserMongo.get())) :
                Optional.empty();
    }
}
