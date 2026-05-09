package br.com.chatbot.adapter.out.repository.persistance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chatbot.adapter.out.repository.entity.MensagemEntity;

public interface MensagemRepository extends JpaRepository<MensagemEntity, Long> {
    Page<MensagemEntity> findAllByUsuarioId(Long usuarioId, Pageable paginacao);
}
