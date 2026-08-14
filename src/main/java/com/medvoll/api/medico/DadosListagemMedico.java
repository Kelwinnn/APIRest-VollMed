package com.medvoll.api.medico;

public record DadosListagemMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {

    //Metodo construtor de medico
    public DadosListagemMedico(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
