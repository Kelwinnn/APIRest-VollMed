package com.medvoll.api.pacientes;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacientesController {

    @PostMapping
    public void cadastrarPaciente(@RequestBody DadosCadastroPaciente dados){
        System.out.println(dados);

    }
}
