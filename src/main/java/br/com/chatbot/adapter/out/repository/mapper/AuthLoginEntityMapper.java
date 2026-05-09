package br.com.chatbot.adapter.out.repository.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.chatbot.adapter.out.repository.entity.AuthLoginEntity;
import br.com.chatbot.application.core.domain.model.AuthLogin;

@Component
@Service
public class AuthLoginEntityMapper {
    public AuthLogin toDomain(AuthLoginEntity dados) {
        return new AuthLogin(
                dados.getId(),
                dados.getLogin(),
                dados.getSenha(),
                dados.getPerfil());
    }

    public AuthLoginEntity toEntity(AuthLogin dados) {
        return new AuthLoginEntity(
                dados.getId(),
                dados.getLogin(),
                dados.getSenha(),
                dados.getPerfil());
    }
}
