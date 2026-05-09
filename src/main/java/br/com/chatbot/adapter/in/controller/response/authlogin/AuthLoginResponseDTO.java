package br.com.chatbot.adapter.in.controller.response.authlogin;

import br.com.chatbot.application.core.domain.enums.Perfil;

public record AuthLoginResponseDTO(
                Long id,
                String login,
                String senha,
                Perfil perfil) {

}
