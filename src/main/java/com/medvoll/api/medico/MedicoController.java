package com.medvoll.api.medico;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    //permite que o Spring injete uma dependência que ele gerencia dentro de outra classe
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody DadosCadastroMedicos dados){
        //Salvando os dados dentro do repository, recebendo os dados do Json atraves do metodo construtor do medico e passando para o Repository
        repository.save(new Medico(dados));
    }

}
