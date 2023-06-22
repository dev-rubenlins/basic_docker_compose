package com.basic.docker.compose.example.util;

public class ExceptionUtils {

    private static final String REGISTER_USER_ERROR = "Occurred an error while %s: %s - %s";

    public static Throwable getRootCause(Throwable t) {
        if (t == null) return null;
        Throwable rootCause = t;
        while (rootCause.getCause() != null){
            rootCause = rootCause.getCause();
        }
        return rootCause;
    }

    public static String formatErrorMessage(String action, Throwable error) {
        Throwable rootCause = getRootCause(error);
        return String.format(REGISTER_USER_ERROR, action, rootCause.getClass().getName(), rootCause.getMessage());
    }

}
