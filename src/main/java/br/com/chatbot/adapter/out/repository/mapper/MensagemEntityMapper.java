package br.com.chatbot.adapter.out.repository.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.chatbot.adapter.out.repository.entity.MensagemEntity;
import br.com.chatbot.application.core.domain.model.Mensagem;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Service
public class MensagemEntityMapper {

    private final UsuarioEntityMapper usuarioEntityMapper;

    public Mensagem toDomain(MensagemEntity dados) {
        return new Mensagem(
                dados.getId(),
                dados.getRole(),
                dados.getContent(),
                dados.getDataHora(),
                usuarioEntityMapper.toDomain(dados.getUsuario()));
    }

    public MensagemEntity toEntity(Mensagem dados) {
        return new MensagemEntity(
                dados.getId(),
                dados.getRole(),
                dados.getContent(),
                dados.getDataHora(),
                usuarioEntityMapper.toEntity(dados.getUsuario()));
    }
}
