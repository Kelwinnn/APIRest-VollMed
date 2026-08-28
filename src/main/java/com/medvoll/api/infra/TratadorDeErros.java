package com.medvoll.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Calsse para tratar erros
@RestControllerAdvice
public class TratadorDeErros {

    //Tratando quando não encontrar o que a requisição está pedindo, ele retorna um notFound
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();
    }
}
