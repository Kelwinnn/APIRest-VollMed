package com.medvoll.api.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity(name = "User")
//Cria os metodos Getters, Metodos Construtores Vazios e Cheios
@Getter
@NoArgsConstructor
@AllArgsConstructor
//Cria o equals e hash code para o atributo escolhido
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;
}
