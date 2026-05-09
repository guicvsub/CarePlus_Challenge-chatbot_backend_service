package br.com.chatbot.application.core.usecase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.chatbot.adapter.in.controller.mapper.UsuarioDTOMapper;
import br.com.chatbot.adapter.in.controller.request.usuario.UsuarioCreateDTO;
import br.com.chatbot.adapter.in.controller.response.usuario.UsuarioDetailedResponseDTO;
import br.com.chatbot.adapter.in.controller.response.usuario.UsuarioResponseDTO;
import br.com.chatbot.adapter.out.repository.entity.UsuarioEntity;
import br.com.chatbot.adapter.out.repository.mapper.UsuarioEntityMapper;
import br.com.chatbot.adapter.out.repository.persistance.UsuarioRepository;
import br.com.chatbot.application.core.domain.model.Usuario;
import br.com.chatbot.exception.type.usuario.UsuarioNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;
    private final UsuarioDTOMapper dtoMapper;
    private final UsuarioEntityMapper entityMapper;

    @Transactional
    public UsuarioDetailedResponseDTO cadastrarUsuario(UsuarioCreateDTO dto) {
        Usuario domain = dtoMapper.toDomain(dto);
        UsuarioEntity entity = repository.save(entityMapper.toEntity(domain));
        return dtoMapper.toDetailedResponseDTO(entityMapper.toDomain(entity));
    }

    public Page<UsuarioResponseDTO> listarUsuariosAtivos(Pageable paginacao) {
        return repository
                .findAllByAtivoTrue(paginacao)
                .map(entityMapper::toDomain)
                .map(dtoMapper::toResponseDTO);
    }

    public Page<UsuarioDetailedResponseDTO> listarUsuarios(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(entityMapper::toDomain)
                .map(dtoMapper::toDetailedResponseDTO);
    }

    public UsuarioDetailedResponseDTO buscarUsuario(Long id) {
        return repository.findById(id)
                .map(entityMapper::toDomain)
                .map(dtoMapper::toDetailedResponseDTO)
                .orElseThrow(() -> new UsuarioNotFoundException(
                        "Usuário não encontrado com o id: " + id));
    }

    @Transactional
    public void deletarUsuario(Long id) {
        UsuarioEntity entity = repository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(
                    "Usuário não encontrado com o id: " + id));
        Usuario domain = entityMapper.toDomain(entity);
        domain.excluir();
        repository.save(entityMapper.toEntity(domain));
    }
}
