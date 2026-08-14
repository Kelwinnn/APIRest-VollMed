package com.medvoll.api.pacientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacientesController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public void cadastrarPaciente(@RequestBody DadosCadastroPaciente dados){
        repository.save(new Paciente(dados));
    }


}
