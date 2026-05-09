package br.com.chatbot.application.core.usecase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.chatbot.adapter.in.controller.mapper.AuthLoginDTOMapper;
import br.com.chatbot.adapter.in.controller.request.authlogin.AuthLoginCreateDTO;
import br.com.chatbot.adapter.in.controller.response.authlogin.AuthLoginResponseDTO;
import br.com.chatbot.adapter.out.repository.entity.AuthLoginEntity;
import br.com.chatbot.adapter.out.repository.mapper.AuthLoginEntityMapper;
import br.com.chatbot.adapter.out.repository.persistance.AuthLoginRepository;
import br.com.chatbot.application.core.domain.model.AuthLogin;
import br.com.chatbot.exception.type.loginauth.AuthLoginNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthLoginService {
    private final AuthLoginRepository repository;
    private final AuthLoginDTOMapper dtoMapper;
    private final AuthLoginEntityMapper entityMapper;

    @Transactional
    public AuthLoginResponseDTO cadastrarAuthLogin(AuthLoginCreateDTO dto) {
        AuthLogin domain = dtoMapper.toDomain(dto);
        AuthLoginEntity entity = repository.save(entityMapper.toEntity(domain));
        return dtoMapper.toResponseDTO(entityMapper.toDomain(entity));
    }

    public Page<AuthLoginResponseDTO> listarAuthLogins(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(entityMapper::toDomain)
                .map(dtoMapper::toResponseDTO);
    }

    public AuthLoginResponseDTO buscarAuthLogin(Long id) {
        return repository.findById(id)
                .map(entityMapper::toDomain)
                .map(dtoMapper::toResponseDTO)
                .orElseThrow(() -> new AuthLoginNotFoundException(
                        "Login de Acesso não encontrado com o id: " + id));
    }

    @Transactional
    public void deletarAuthLogin(Long id) {
        AuthLoginEntity entity = repository.findById(id)
                .orElseThrow(() -> new AuthLoginNotFoundException(
                    "Login de Acesso não encontrado com o id: " + id));
        repository.delete(entity);
    }
}
