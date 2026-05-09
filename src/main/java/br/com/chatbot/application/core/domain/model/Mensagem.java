package br.com.chatbot.application.core.domain.model;

import java.time.LocalDateTime;

import br.com.chatbot.adapter.in.controller.request.mensagem.MensagemCreateDTO;
import br.com.chatbot.application.core.domain.enums.Role;

public class Mensagem {
    private Long id;
    private Role role;
    private String content;
    private LocalDateTime dataHora;
    private Usuario usuario;

    public Mensagem() {
    }

    public Mensagem(Long id, Role role, String content, LocalDateTime dataHora, Usuario usuario) {
        this.id = id;
        this.role = role;
        this.content = content;
        this.dataHora = dataHora;
        this.usuario = usuario;
    }

    public Mensagem(MensagemCreateDTO dados, Usuario usuario) {
        this.role = dados.role();
        this.content = dados.content();
        this.dataHora = LocalDateTime.now();
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
