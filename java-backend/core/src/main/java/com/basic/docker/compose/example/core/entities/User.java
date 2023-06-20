package com.basic.docker.compose.example.core.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    private final UUID id;
    private final String email;
    private String password;

    public User(@Email String email, @Min(6) String password) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.password = password;
    }

    public void changePassword(@Min(6) String newPassword){
        assert(!newPassword.equals(password));
        this.password = newPassword;
    }
}
