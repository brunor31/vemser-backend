package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.EnderecoService;
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
@RequestMapping("/endereco")
@Validated
@Slf4j
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Operation(summary = "Listar endereçocs", description = "Lista todos endereços")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista os endereços"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public List<EnderecoDTO> list() {
        log.info("listar endereços");
        return enderecoService.listar();
    }
    @Operation(summary = "Listar um endereço por id", description = "Lista um endereço especifico")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista um endereço por id"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idEndereco}")
    public EnderecoDTO listById(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        log.info("listar endereço");
        return enderecoService.findByIdDTO(id);
    }
    @Operation(summary = "Lista todos endereços de uma pessoa", description = "Lista de endereços por idPessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista um endereço por idPessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        log.info("listar endereços por pessoa");
        return enderecoService.listByIdPessoa(id);
    }
    @Operation(summary = "Cria um endereço", description = "Cria um endereço e atribuí a uma pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cria um novo endereço"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}")
    public EnderecoDTO create(@PathVariable("idPessoa") Integer id,
                           @RequestBody @Valid EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        log.info("criar endereço");
        return enderecoService.create(id, endereco);
    }
    @Operation(summary = "Atualiza um endereço", description = "Atualiza um endereço")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Atualiza um endereço"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idEndereco}")
    public void update(@PathVariable("idEndereco") Integer id,
                       @RequestBody @Valid EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        log.info("atualizar endereço");
        enderecoService.update(id, endereco);
    }
    @Operation(summary = "Deleta um endereço", description = "Deleta um endereço")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deleta um endereço"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        log.info("deletar endereço");
        enderecoService.delete(id);
    }
}
