package br.com.chatbot.adapter.out.repository.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.chatbot.adapter.out.repository.entity.UsuarioEntity;
import br.com.chatbot.application.core.domain.model.Usuario;

@Component
@Service
public class UsuarioEntityMapper {

    public Usuario toDomain(UsuarioEntity dados) {
        return new Usuario(
                dados.getId(),
                dados.getCelular(),
                dados.getAtivo());
    }

    public UsuarioEntity toEntity(Usuario dados) {
        return new UsuarioEntity(
                dados.getId(),
                dados.getCelular(),
                dados.getAtivo());
    }
}
