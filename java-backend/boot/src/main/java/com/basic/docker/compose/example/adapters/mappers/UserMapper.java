package com.basic.docker.compose.example.adapters.mappers;

import com.basic.docker.compose.example.entities.User;
import com.basic.docker.compose.example.infra.mongodb.data_model.UserMongoDb;

public interface UserMapper<T extends User> {

    User toDomainModel(T userData);

    T toDataModel(User user);

}
