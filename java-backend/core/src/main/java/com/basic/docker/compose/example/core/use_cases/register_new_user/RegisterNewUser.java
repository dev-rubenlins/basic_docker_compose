package com.basic.docker.compose.example.core.use_cases.register_new_user;

import br.dev.rubenlins.clean_architecture.basics.EventPublisher;
import br.dev.rubenlins.clean_architecture.basics.OperationResult;
import br.dev.rubenlins.clean_architecture.basics.ResultType;
import br.dev.rubenlins.clean_architecture.basics.UseCase;

import com.basic.docker.compose.example.core.entities.User;
import com.basic.docker.compose.example.core.entities.UserRepo;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static br.dev.rubenlins.clean_architecture.basics.OperationResult.fail;
import static br.dev.rubenlins.clean_architecture.basics.OperationResult.success;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RegisterNewUser implements UseCase<RegisterNewUserRequest, RegisterNewUserResponse> {

    private static final String INVALID_PASSWORD = "Given password does not match security policy.";
    private static final String USER_ALREADY_EXISTS = "There is already an user associated to given e-mail.";

    private final UserRepo userRepo;
    private final EventPublisher eventPublisher;

    private boolean userExists(String email) {
        return userRepo.userExists(email);
    }

    private boolean passwordIsValid(String password) {
        //TODO define password policy
        return true;
    }

    private UUID registerUser(String email, String password) {
        User user = new User(email, password);
        userRepo.saveUser(user);
        return user.getId();
    }

    private void notifyUserNotRegistered(UUID requestId, List<String> occurrences) {
        UserNotRegistered event = UserNotRegistered
                .builder()
                .requestID(requestId)
                .ccurrences(occurrences)
                .build();
        eventPublisher.publish(event);
    }

    private void notifyNewUserRegistered(UUID requestId, UUID userID) {
        NewUserRegistered event = NewUserRegistered
                .builder()
                .requestID(requestId)
                .additionalData(Optional.of(userID))
                .build();
        eventPublisher.publish(event);
    }
    @Override
    public RegisterNewUserResponse execute(@NotNull RegisterNewUserRequest request) {

        UUID requestId = request.getRequestID();
        String email = request.getEmail();
        String password = request.getPasword();

        OperationResult result = success();
        List<String> occurrences = new ArrayList<>();

        boolean userExists = userExists(email);

        if (userExists(email)){
            occurrences.add(USER_ALREADY_EXISTS);
            result = fail(occurrences);
        }

        if (passwordIsValid(password)){
            occurrences.add(INVALID_PASSWORD);
            result = fail(occurrences);
        }

        if (result.getResultType().equals(ResultType.SUCCESS)){
            UUID userID = registerUser(email, password);
            notifyNewUserRegistered(requestId,userID);
        } else {
            notifyUserNotRegistered(requestId,occurrences);
        }

        return new RegisterNewUserResponse(requestId, result);
    }



}
