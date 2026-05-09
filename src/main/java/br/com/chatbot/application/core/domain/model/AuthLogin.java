package br.com.chatbot.application.core.domain.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.chatbot.adapter.in.controller.request.authlogin.AuthLoginCreateDTO;
import br.com.chatbot.application.core.domain.enums.Perfil;

public class AuthLogin implements UserDetails {
    private Long id;
    private String login;
    private String senha;
    private Perfil perfil;

    public AuthLogin() {
    }

    public AuthLogin(Long id, String login, String senha, Perfil perfil) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    public AuthLogin(AuthLoginCreateDTO dados) {
        this.login = dados.login();
        this.senha = dados.senha();
        this.perfil = dados.perfil();
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + perfil));
    }

    @Override
    public String getPassword() {
        return getSenha();
    }

    @Override
    public String getUsername() {
        return getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;// default: UserDetails.super.isAccountNonExpired()
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;// default: UserDetails.super.isAccountNonLocked()
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;// default: UserDetails.super.isCredentialsNonExpired()
    }

    @Override
    public boolean isEnabled() {
        return true;// default: UserDetails.super.isEnabled()
    }
}
