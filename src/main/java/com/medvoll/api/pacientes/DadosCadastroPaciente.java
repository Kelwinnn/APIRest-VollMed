package com.medvoll.api.pacientes;

import com.medvoll.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DadosCadastroPaciente(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @Pattern(regexp = "\\d{20}")
        String telefone,
        @NotBlank
        String cpf,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}
