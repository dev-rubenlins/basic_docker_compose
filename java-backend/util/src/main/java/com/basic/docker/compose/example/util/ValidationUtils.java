package com.basic.docker.compose.example.util;

import java.util.regex.Pattern;

public class ValidationUtils {

    public static final String PASSWORD_DOES_NOT_MATCH_PATTERN_MSG = "Given password does not match defined pattern";
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6,15}$";

    private static Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);

    public static boolean passwordValid(final String password) {
        return passwordPattern.matcher(password).matches();
    }
}
