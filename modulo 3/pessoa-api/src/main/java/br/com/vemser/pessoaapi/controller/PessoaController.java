package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.config.PropertieReader;
import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")  // localhost:8080/pessoa/hello
@Validated
@Slf4j
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PropertieReader propertieReader;

//    @GetMapping("/hello") // localhost:8080/pessoa/hello
//    public String hello() {
//        return "Hello World";
//    }
//
//    @GetMapping("/ambiente")
//    public String propertReader() {
//        return propertieReader.getAmbiente();
//    }

    @Operation(summary = "Listar pessoa pelo nome", description = "Retorna uma pessoa da lista pelo nome")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a pessoa pelo nome"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public List<PessoaDTO> listByName(@RequestParam("nome") String name) {
        log.info("lista pessoa por nome");
        return pessoaService.listByName(name);
    }

    @Operation(summary = "Listar pessoas", description = "Lista todas as pessoas")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping // localhost:8080/pessoa
    public List<PessoaDTO> list() {
        log.info("listar pessoas");
        return pessoaService.listar();
    }
    @Operation(summary = "Criar uma nova pessoa", description = "Cria uma nova pessoa e inclui no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cria uma nova pessoa e armazena no banco"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping // localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@RequestBody @Valid PessoaCreateDTO pessoa) {
        log.info("criar pessoa");
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }
    @Operation(summary = "Atualizar uma pessoa", description = "Busca uma pessoa no banco pelo id e atualiza")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Atualizar uma pessoa do banco"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public void update(@PathVariable("idPessoa") Integer id,
                       @RequestBody @Valid PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        log.info("atualizar pessoa");
        pessoaService.update(id, pessoa);
    }
    @Operation(summary = "Deletar uma pessoa", description = "Busca uma pessoa no banco pelo id e deleta")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pessoa deleteda"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        log.info("deletar pessoa");
        pessoaService.delete(id);
    }
}
