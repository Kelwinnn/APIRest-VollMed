package com.medvoll.api.domain.user;

public record DadosAutenticacao(
        Long id,
        String login,
        String senha
) {
}
