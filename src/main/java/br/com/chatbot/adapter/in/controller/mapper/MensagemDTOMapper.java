package br.com.chatbot.adapter.in.controller.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.chatbot.adapter.in.controller.response.mensagem.MensagemResponseDTO;
import br.com.chatbot.application.core.domain.model.Mensagem;

@Component
@Service
public class MensagemDTOMapper {
    public MensagemResponseDTO toResponseDTO(Mensagem dados) {
        return new MensagemResponseDTO(
                dados.getId(),
                dados.getRole(),
                dados.getContent(),
                dados.getDataHora(),
                dados.getUsuario().getCelular());
    }
}
