package com.basic.docker.compose.example.infra.spring.controllers.register_new_user;

import com.basic.docker.compose.example.clean_arch.util.OperationResult;
import com.basic.docker.compose.example.use_cases.RegisterNewUser;
import com.basic.docker.compose.example.use_cases.RegisterNewUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
@Slf4j
public class RegisterNewUserController {

    private final RegisterNewUser registerNewUser;

    @Autowired
    public RegisterNewUserController(RegisterNewUser registerNewUser) {
        this.registerNewUser = registerNewUser;
    }

    @PostMapping(value = "/register", consumes = "application/json")
    public RegisterNewUserHttpResponse registerNewUser(@RequestBody  RegisterNewUserHttpRequest request) {
        RegisterNewUserResponse response = registerNewUser.execute(request);
        return new RegisterNewUserHttpResponse(response);
    }


}
