package com.medvoll.api.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//Esse component serve para que adicione um filtro no momento que a requisição for chamada, aqui estamos utilizando como forma de barrar que um outro usuario possa enviar ou receber requisições sem as permissões devidas.ss
@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = recuperarToken(request);



        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader == null){
            throw new RuntimeException("Token JWT não enviado no cabeçalho Authorization!");
        }
        return authorizationHeader.replace("Bearer ", "");
    }
}
