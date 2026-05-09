package br.com.chatbot.adapter.in.controller.request.authlogin;

import br.com.chatbot.application.core.domain.enums.Perfil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthLoginCreateDTO(
                @NotBlank String login,
                @NotBlank String senha,
                @NotNull Perfil perfil) {

}
