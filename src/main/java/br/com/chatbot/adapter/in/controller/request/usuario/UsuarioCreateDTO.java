package br.com.chatbot.adapter.in.controller.request.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UsuarioCreateDTO(
        @NotBlank @Pattern(regexp = "\\d{9,13}") String celular) {

}
