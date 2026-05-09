package br.com.chatbot.adapter.out.repository.persistance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.chatbot.adapter.out.repository.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Page<UsuarioEntity> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select e.ativo
            from Usuario e
            Where
            e.id = :id
            """)
    Boolean findAtivoById(Long id);
}
