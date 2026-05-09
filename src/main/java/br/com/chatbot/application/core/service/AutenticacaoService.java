package br.com.chatbot.application.core.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.chatbot.adapter.out.repository.mapper.AuthLoginEntityMapper;
import br.com.chatbot.adapter.out.repository.persistance.AuthLoginRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AutenticacaoService implements UserDetailsService {

    private final AuthLoginRepository repository;
    private final AuthLoginEntityMapper usuarioEntityMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioEntityMapper.toDomain(repository.findByLogin(username));
    }
}
