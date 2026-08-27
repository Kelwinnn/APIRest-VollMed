package com.medvoll.api.controller;

import com.medvoll.api.medico.DadosDetalhamentoMedico;
import com.medvoll.api.pacientes.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
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
       return repository.findAllByAtivoTrue(pagination).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados){
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativar(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.inativar();
        return ResponseEntity.noContent().build();
    }
}
