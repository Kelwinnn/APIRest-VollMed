package com.medvoll.api.medico;

import com.medvoll.api.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "medicos")
@Entity(name = "Medico")
//Cria os metodos Getters, Metodos Construtores Vazios e Cheios
@Getter
@NoArgsConstructor
@AllArgsConstructor
//Cria o equals e hash code para o atributo escolhido
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    //É usada em atributos do tipo enum dentro de entidades JPA para controlar como o enum será persistido no banco de dados.
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    //Essa anotação é para dizer que essa classe é uma classe separada (ou tabela separada no JPA), porém, ela vai estar relacionada com a classe/tabela.
    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedicos dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualiazarInformacoes(DadosAtualizacaoMedicos dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }
}
