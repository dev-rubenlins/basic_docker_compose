package com.basic.docker.compose.example.core.adapters.mappers;

import br.dev.rubenlins.clean_architecture.basics.ReflectionUtils;
import com.basic.docker.compose.example.core.entities.User;
import com.basic.docker.compose.example.core.entities.UserContract;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class UserMapper<T extends UserContract> {

    public User toDomainModel(@NotNull UserContract externalModel){
        return new User(
                externalModel.getId(),
                externalModel.getEmail(),
                externalModel.getPassword());
    }

    public Collection<User> toDomainModel(Collection<UserContract> externalModelList){
        return externalModelList
                .stream()
                .map(externalModel -> toDomainModel(externalModel))
                .collect(Collectors.toList());
    }

    public <T extends UserContract> T toExternalModel (@NotNull Class<T> clazz, @NotNull User domainModel){
        T externalModel = ReflectionUtils.newInstance(clazz);
        externalModel.setId(domainModel.getId());
        externalModel.setEmail(domainModel.getEmail());
        externalModel.setPassword(domainModel.getPassword());
        return externalModel;
    }

    public <T extends UserContract> Collection<T> toExternalModel(@NotNull Class<T> clazz,
                                                                  @NotNull Collection<User> domainModelList){
        return domainModelList
                .stream()
                .map(domainModel -> toExternalModel(clazz, domainModel))
                .collect(Collectors.toList());
    }

}
