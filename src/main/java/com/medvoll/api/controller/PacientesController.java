package com.medvoll.api.controller;

import com.medvoll.api.pacientes.DadosCadastroPaciente;
import com.medvoll.api.pacientes.DadosListagemPaciente;
import com.medvoll.api.pacientes.Paciente;
import com.medvoll.api.pacientes.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacientesController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public void cadastrarPaciente(@RequestBody DadosCadastroPaciente dados){
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable pagination){
       return repository.findAll(pagination).map(DadosListagemPaciente::new);
    }
}
