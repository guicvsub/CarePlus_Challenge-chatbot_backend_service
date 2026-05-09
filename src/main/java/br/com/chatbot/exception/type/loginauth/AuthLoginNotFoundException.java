package br.com.chatbot.exception.type.loginauth;

public class AuthLoginNotFoundException extends RuntimeException {
    public AuthLoginNotFoundException(String message) {
        super(message);
    }

    public AuthLoginNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
