package com.medvoll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//Classe repository é basicamente a classe que irá conversar com o meu banco de dados, que já vai receber algumas funções do proprio banco, funções como INSERT, SELECT e entre outras. (Metodos CRUD)
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable pagination);
}
