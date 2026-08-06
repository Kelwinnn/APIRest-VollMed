package com.medvoll.api.medico;

import com.medvoll.api.endereco.DadosEndereco;

//Basicamente o Record facilita a criação do codigo e o deixa mais enxuto, sem necessida de criar metodos Getters, Setters e contrutores.
public record DadosCadastroMedicos(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {
}
