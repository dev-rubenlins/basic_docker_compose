package com.basic.docker.compose.example.adapters.mappers;

import com.basic.docker.compose.example.entities.User;
import com.basic.docker.compose.example.entities.UserFactory;
import com.basic.docker.compose.example.infra.mongodb.data_model.UserMongoDb;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserMongoDbMapper implements UserMapper<UserMongoDb> {

    private final UserFactory userFactory;

    public User toDomainModel(UserMongoDb mongoUser){
        return userFactory.loadUser(mongoUser.getId(), mongoUser.getEmail(), mongoUser.getPassword());
    }

    public UserMongoDb toDataModel(User user){
        return new UserMongoDb(user.getId(), user.getEmail(), user.getPassword());
    }
}
