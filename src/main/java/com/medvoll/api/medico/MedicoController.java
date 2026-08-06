package com.medvoll.api.medico;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @PostMapping
    public void cadastrarMedico(@RequestBody DadosCadastroMedicos dados){
        System.out.println(dados.crm());
    }

}
