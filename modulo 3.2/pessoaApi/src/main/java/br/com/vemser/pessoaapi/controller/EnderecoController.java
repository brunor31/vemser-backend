package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.vemser.pessoaapi.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
@Slf4j
@ApiResponses({
        @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
        @ApiResponse(responseCode = "404", description = "Endereço não encontrado"),
        @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
})
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Operation(summary = "Listar endereçocs", description = "Lista todos endereços")
    @ApiResponse(responseCode = "200", description = "Lista todos os endereços do banco")
    @GetMapping
    public List<EnderecoDTO> list() {
        log.info("listar endereços");
        return enderecoService.listar();
    }

    @Operation(summary = "Listar um endereço por id", description = "Lista um endereço especifico")
    @ApiResponse(responseCode = "200", description = "Lista um endereço por id")
    @GetMapping("/{idEndereco}")
    public EnderecoDTO listById(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        log.info("listar endereço por id");
        return enderecoService.findByIdDTO(id);
    }

    @Operation(summary = "Lista todos endereços de uma pessoa", description = "Lista de endereços por idPessoa")
    @ApiResponse(responseCode = "200", description = "Lista um endereço por idPessoa")
    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        log.info("listar endereços por pessoa");
        return enderecoService.listByIdPessoa(id);
    }

    @Operation(summary = "Cria um endereço", description = "Cria um endereço e atribuí a uma pessoa")
    @ApiResponse(responseCode = "200", description = "Cria um novo endereço")
    @PostMapping("/{idPessoa}")
    public EnderecoDTO create(@PathVariable("idPessoa") Integer id,
                              @RequestBody @Valid EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        log.info("criar endereço");
        return enderecoService.create(id, endereco);
    }

    @Operation(summary = "Atualiza um endereço", description = "Atualiza um endereço")
    @ApiResponse(responseCode = "200", description = "Atualiza um endereço")
    @PutMapping("/{idEndereco}")
    public void update(@PathVariable("idEndereco") Integer id,
                       @RequestBody @Valid EnderecoDTO endereco) throws RegraDeNegocioException {
        log.info("atualizar endereço");
        enderecoService.update(id, endereco);
    }

    @Operation(summary = "Deleta um endereço", description = "Deleta um endereço")
    @ApiResponse(responseCode = "200", description = "Deleta um endereço")
    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        log.info("deletar endereço");
        enderecoService.delete(id);
    }

    @GetMapping("/cep")
    public Page<EnderecoEntity> listByCep(Integer pagina, Integer registros){
        Sort order = Sort.by("cep");
        Pageable pageable = PageRequest.of(pagina, registros, order);
        return enderecoRepository.lisByCep(pageable);
    }

    @GetMapping("/pais")
    public Page<EnderecoEntity> lisByCountry(@RequestParam("pais")String pais, Integer pagina, Integer registros){
        Sort order = Sort.by("pais");
        Pageable pageable = PageRequest.of(pagina, registros, order);
        return enderecoRepository.findByPaisIgnoreCase(pais, pageable);
    }

}
