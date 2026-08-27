package com.medvoll.api.pacientes;

import com.medvoll.api.endereco.Endereco;
import com.medvoll.api.medico.Medico;

public record DadosDetalhamentoPaciente(Long id, String nome, String email, String telefone, String cpf, Endereco endereco) {
    public DadosDetalhamentoPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}
