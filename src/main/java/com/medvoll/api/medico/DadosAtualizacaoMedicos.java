package com.medvoll.api.medico;

import com.medvoll.api.endereco.DadosEndereco;
import com.medvoll.api.endereco.Endereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedicos(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
