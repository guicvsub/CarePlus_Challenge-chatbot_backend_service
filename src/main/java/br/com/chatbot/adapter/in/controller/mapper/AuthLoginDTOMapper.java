package br.com.chatbot.adapter.in.controller.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.chatbot.adapter.in.controller.request.authlogin.AuthLoginCreateDTO;
import br.com.chatbot.adapter.in.controller.response.authlogin.AuthLoginResponseDTO;
import br.com.chatbot.application.core.domain.model.AuthLogin;

@Component
@Service
public class AuthLoginDTOMapper {
    public AuthLogin toDomain(AuthLoginCreateDTO dados) {
        return new AuthLogin(
                null,
                dados.login(),
                dados.senha(),
                dados.perfil());
    }

    public AuthLoginResponseDTO toResponseDTO(AuthLogin dados) {
        return new AuthLoginResponseDTO(
                dados.getId(),
                dados.getLogin(),
                dados.getSenha(),
                dados.getPerfil());
    }
}
