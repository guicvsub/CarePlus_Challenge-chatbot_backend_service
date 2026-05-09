package br.com.chatbot.adapter.out.repository.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chatbot.adapter.out.repository.entity.AuthLoginEntity;

public interface AuthLoginRepository extends JpaRepository<AuthLoginEntity, Long> {
    AuthLoginEntity findByLogin(String login);
}
