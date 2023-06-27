package com.basic.docker.compose.example.infra.mongodb.data_model;

import com.basic.docker.compose.example.clean_arch.util.OperationResult;
import com.basic.docker.compose.example.util.ObjectUtils;
import lombok.*;

import com.basic.docker.compose.example.entities.User;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.basic.docker.compose.example.clean_arch.util.OperationResult.fail;

@Document("users")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"id"})
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class UserMongoDb implements User {

    @Id
    private UUID id;
    private String email;
    private String password;

    @Override
    public OperationResult changePassword(String newPassword) {
        return fail(List.of("Invalid operation at persistence level. " +
                "Please invoke this operation at business rules level."));
    }
}
