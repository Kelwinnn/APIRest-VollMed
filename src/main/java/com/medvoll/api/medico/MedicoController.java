package com.medvoll.api.medico;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    //permite que o Spring injete uma dependência que ele gerencia dentro de outra classe
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedicos dados){ //Sempre lembrar de colocar a anotação Valid para que utilize o bean validation que foi configurado na classe.
        //Salvando os dados dentro do repository, recebendo os dados do Json atraves do metodo construtor do medico e passando para o Repository
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(Pageable pagination){
        return repository.findAll(pagination).map(DadosListagemMedico::new);
    }

}
