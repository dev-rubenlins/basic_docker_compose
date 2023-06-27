package com.basic.docker.compose.example.use_cases.internal;

import com.basic.docker.compose.example.clean_arch.util.EventPublisher;
import com.basic.docker.compose.example.clean_arch.util.OperationResult;
import com.basic.docker.compose.example.entities.User;
import com.basic.docker.compose.example.entities.UserFactory;
import com.basic.docker.compose.example.use_cases.*;
import com.basic.docker.compose.example.util.ExceptionUtils;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.basic.docker.compose.example.util.ValidationUtils.*;
import static com.basic.docker.compose.example.clean_arch.util.OperationResult.*;

@RequiredArgsConstructor
public class RegisterNewUserUseCase implements RegisterNewUser {

    private static final String USER_ALREADY_EXISTS = "There is already an user associated to given e-mail.";
    private static final String USE_CASE_ACTION = "registering user";

    private final UserGateway userGateway;
    private final UserFactory userFactory;
    private final EventPublisher eventPublisher;
    private final RegisterNewUserPresenter presenter;

    private boolean userExists(String email) {
        return userGateway.userExists(email);
    }

    private boolean passwordIsValid(String password) {
        return passwordValid(password);
    }

    private void persistUser(User user){
        userGateway.save(user);
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
    public RegisterNewUserResponse execute(RegisterNewUserRequest request) {

        UUID requestId = request.getRequestID();
        String email = request.getEmail();
        String password = request.getPassword();

        OperationResult result = success();
        List<String> occurrences = new ArrayList<>();

        boolean userExists = userExists(email);

        if (userExists(email)){
            occurrences.add(USER_ALREADY_EXISTS);
            result = fail(occurrences);
        }

        if (passwordIsValid(password)){
            occurrences.add(PASSWORD_DOES_NOT_MATCH_PATTERN_MSG);
            result = fail(occurrences);
        }

        try {
            if (result.isSuccess()){
                User user = userFactory.newUser(email, password);
                persistUser(user);
                notifyNewUserRegistered(requestId,user.getId());
            } else {
                notifyUserNotRegistered(requestId,occurrences);
            }

        } catch (Throwable t) {
            result = OperationResult.fail(List.of(ExceptionUtils.formatErrorMessage(USE_CASE_ACTION, t)));
        }

        RegisterNewUserResponse response = new RegisterNewUserResponse(requestId, result);

        return result.isSuccess() ?
                presenter.prepareSuccessView(response) :
                presenter.prepareFailView(response);

    }
}
