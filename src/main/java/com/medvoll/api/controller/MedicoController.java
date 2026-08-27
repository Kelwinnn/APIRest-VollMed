package com.medvoll.api.controller;

import com.medvoll.api.medico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("medicos")
public class MedicoController {

    //permite que o Spring injete uma dependência que ele gerencia dentro de outra classe
    @Autowired
    private MedicoRepository repository;

    //Metodo post, para postar informações
    @PostMapping
    //O @Transactional garante que um conjunto de operações no banco de dados seja executado como uma única unidade: ou tudo é salvo com sucesso, ou tudo é cancelado em caso de erro.
    @Transactional
    public ResponseEntity cadastrarMedico(@RequestBody @Valid DadosCadastroMedicos dados, UriComponentsBuilder uriBuilder){ //Sempre lembrar de colocar a anotação Valid para que utilize o bean validation que foi configurado na classe.
        //Salvando os dados dentro do repository, recebendo os dados do Json atraves do metodo construtor do medico e passando para o Repository
        var medico = new Medico(dados);
        repository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    //Metodo para pegar as informações
    @GetMapping
    //Criou um metodo que utiliza o Page<Classe do Pageable> para listar as informações e setou como default os quantas informações irão aparecer de size e ordenação
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagination){
        //O metodo retornara o meu repository e irá pegar todas as informações que estão no Dados de listagem
        var page =  repository.findAllByAtivoTrue(pagination).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page);
    }

    //Criando um metodo para editar / PUT
    @PutMapping
    @Transactional
    //Utilizanodo o ResponseEntity para devolver uma nova requisição
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedicos dados){
        //Guarda em uma variavel o id do medico, através do repository
        var medico = repository.getReferenceById(dados.id());
        medico.atualiazarInformacoes(dados);
        //Importante -> Não é recomendado devolver e receber entidades JPA no Controller.
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }


    //Metodo para deletar informações / DELETE
    @DeleteMapping("/{id}")
    @Transactional
    //Utilizanodo o ResponseEntity para devolver uma nova requisição
    //Utilizando a anotação de PahtVariable, o Spring vai entender que o ID que eu estou passando na minha URL da pagina vai ser o id que eu vou precisar excluir
    public ResponseEntity excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
        //Boa pratica para retornar valor de 204 que não vai retornar nenhum conteudo
        return ResponseEntity.noContent().build();
    }

}
