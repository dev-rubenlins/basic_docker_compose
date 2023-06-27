package com.basic.docker.compose.example.entities.internal;

import com.basic.docker.compose.example.clean_arch.util.OperationResult;
import com.basic.docker.compose.example.entities.User;
import com.basic.docker.compose.example.util.ObjectUtils;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

import static com.basic.docker.compose.example.clean_arch.util.OperationResult.fail;
import static com.basic.docker.compose.example.clean_arch.util.OperationResult.success;
import static com.basic.docker.compose.example.util.ValidationUtils.PASSWORD_DOES_NOT_MATCH_PATTERN_MSG;
import static com.basic.docker.compose.example.util.ValidationUtils.passwordValid;

@Getter
@AllArgsConstructor
public class CommonUser implements User {

    @Override
    public boolean equals(Object o) { return ObjectUtils.equals(this,o,"id"); }

    @Override
    public int hashCode() { return getId().hashCode(); }

    private final UUID id;
    private final String email;
    private String password;

    public CommonUser(String email, String password) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.password = password;
    }

    @Override
    public OperationResult changePassword(@NotNull String newPassword) {
        var result = success();
        if (!passwordValid(newPassword)){
            result = fail(List.of(PASSWORD_DOES_NOT_MATCH_PATTERN_MSG));
        }
        return result;
    }
}
