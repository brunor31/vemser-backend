package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated
@Slf4j
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @Operation(summary = "Listar contatos", description = "Retorna uma lista com todos os contatos")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retornar todos os contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public List<ContatoDTO> list() {
        log.info("listar contatos");
        return contatoService.listar();
    }
    @Operation(summary = "Listar contatos por pessoa", description = "Retorna uma lista com todos os contatos da pessoa informada no campo idPessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retornar todos os contatos da pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}")
    public List<ContatoDTO> listById(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        log.info("listar contatos por pessoa");
        return contatoService.listByIdPessoa(id);
    }
    @Operation(summary = "Criar um novo contato", description = "Cria um novo contato para uma pessoa e armazena no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cria um novo contato"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}")
    public ContatoDTO create(@PathVariable("idPessoa") Integer id,
                          @RequestBody @Valid ContatoCreateDTO contato) throws RegraDeNegocioException {
        log.info("criar contato");
        return contatoService.create(id, contato);
    }
    @Operation(summary = "Atualizar um contato", description = "Busca um contato no banco pelo campo id e atualiza")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Atualiza um contato"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idContato}")
    public void update(@PathVariable("idContato") Integer id,
                       @RequestBody @Valid ContatoCreateDTO contato) throws RegraDeNegocioException {
        log.info("atualizar contato");
        contatoService.update(id, contato);
    }
    @Operation(summary = "Deletar um contato", description = "Busca um contato no banco pelo campo id e deleta")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deleta um contato"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        log.info("deletar contato");
        contatoService.delete(id);
    }
}
