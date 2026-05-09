package br.com.chatbot.exception.type.mensagem;

public class MensagemNotFoundException extends RuntimeException {
    public MensagemNotFoundException(String message) {
        super(message);
    }

    public MensagemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
