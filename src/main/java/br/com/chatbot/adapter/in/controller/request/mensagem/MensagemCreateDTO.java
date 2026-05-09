package br.com.chatbot.adapter.in.controller.request.mensagem;

import br.com.chatbot.application.core.domain.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MensagemCreateDTO(
        @NotNull Role role,
        @NotBlank String content,
        @NotNull Long idUsuario) {

}
