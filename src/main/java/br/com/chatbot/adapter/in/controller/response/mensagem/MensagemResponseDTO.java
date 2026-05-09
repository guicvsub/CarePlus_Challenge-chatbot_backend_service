package br.com.chatbot.adapter.in.controller.response.mensagem;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.chatbot.application.core.domain.enums.Role;

public record MensagemResponseDTO(
                Long id,
                Role role,
                String content,
                @JsonFormat(pattern = "dd/MM/yyyy - HH:mm") LocalDateTime dataHora,
                String celularUsuario) {

}
