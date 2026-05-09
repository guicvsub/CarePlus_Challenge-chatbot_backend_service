package br.com.chatbot.adapter.in.controller.request.authlogin;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginCheckDTO(
                @NotBlank String login,
                @NotBlank String senha) {
}
