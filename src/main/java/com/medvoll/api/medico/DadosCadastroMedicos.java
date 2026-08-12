package com.medvoll.api.medico;

import com.medvoll.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

//Basicamente o Record facilita a criação do codigo e o deixa mais enxuto, sem necessida de criar metodos Getters, Setters e contrutores.
public record DadosCadastroMedicos(
        //Utilizando o bean validation, algumas anotações que vem do pacote Jakarta
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //Uma expressão regular
        String crm,
        @NotNull //Não é utilizado o NotBlank, pois não é uma String, uma vez que ele vai ser pego de uma Classe ENUM e o NotBlank só pode ser utilizado para Strings.
        Especialidade especialidade,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}
