package br.com.chatbot.application.core.usecase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.chatbot.adapter.in.controller.mapper.MensagemDTOMapper;
import br.com.chatbot.adapter.in.controller.request.mensagem.MensagemCreateDTO;
import br.com.chatbot.adapter.in.controller.response.mensagem.MensagemResponseDTO;
import br.com.chatbot.adapter.out.repository.entity.MensagemEntity;
import br.com.chatbot.adapter.out.repository.entity.UsuarioEntity;
import br.com.chatbot.adapter.out.repository.mapper.MensagemEntityMapper;
import br.com.chatbot.adapter.out.repository.mapper.UsuarioEntityMapper;
import br.com.chatbot.adapter.out.repository.persistance.MensagemRepository;
import br.com.chatbot.adapter.out.repository.persistance.UsuarioRepository;
import br.com.chatbot.application.core.domain.model.Mensagem;
import br.com.chatbot.application.core.domain.model.Usuario;
import br.com.chatbot.exception.type.mensagem.MensagemNotFoundException;
import br.com.chatbot.exception.type.usuario.UsuarioNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MensagemService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioEntityMapper usuarioEntityMapper;
    private final MensagemRepository repository;
    private final MensagemDTOMapper dtoMapper;
    private final MensagemEntityMapper entityMapper;

    @Transactional
    public MensagemResponseDTO cadastrarMensagem(MensagemCreateDTO dto) {
        UsuarioEntity usuarioEntity = usuarioRepository
                .findById(dto.idUsuario())
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário não encontrado"));
        Usuario usuarioDomain = usuarioEntityMapper.toDomain(usuarioEntity);
        Mensagem domain = new Mensagem(dto, usuarioDomain);
        MensagemEntity entity = repository.save(entityMapper.toEntity(domain));
        return dtoMapper.toResponseDTO(entityMapper.toDomain(entity));
    }

    public Page<MensagemResponseDTO> listarMensagens(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(entityMapper::toDomain)
                .map(dtoMapper::toResponseDTO);
    }

    public Page<MensagemResponseDTO> listarMensagensPorUsuario(Long usuarioId, Pageable paginacao) {
        if (!usuarioRepository.existsById(usuarioId)) {
            throw new UsuarioNotFoundException("Usuário não encontrado com o id: " + usuarioId);
        }
        return repository
                .findAllByUsuarioId(usuarioId, paginacao)
                .map(entityMapper::toDomain)
                .map(dtoMapper::toResponseDTO);
    }

    public MensagemResponseDTO busacarMensagem(Long id) {
        return repository.findById(id)
                .map(entityMapper::toDomain)
                .map(dtoMapper::toResponseDTO)
                .orElseThrow(() -> new MensagemNotFoundException(
                        "Mensagem não encontrada com o id: " + id));
    }
}
