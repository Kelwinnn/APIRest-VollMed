package com.medvoll.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco (
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        @Pattern(regexp = "\\d{8}") //Expressão regular, onde será recebido 8 digitos.
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        String complemento,
        String numero) {
}
