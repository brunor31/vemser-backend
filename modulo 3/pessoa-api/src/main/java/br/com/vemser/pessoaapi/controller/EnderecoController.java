package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.EnderecoService;
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

    @GetMapping
    public List<EnderecoDTO> list() {
        log.info("listar endereços");
        return enderecoService.listar();
    }

    @GetMapping("/{idEndereco}")
    public EnderecoDTO listById(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        log.info("listar endereço");
        return enderecoService.findByIdDTO(id);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        log.info("listar endereços por pessoa");
        return enderecoService.listByIdPessoa(id);
    }

    @PostMapping("/{idPessoa}")
    public EnderecoDTO create(@PathVariable("idPessoa") Integer id,
                           @RequestBody @Valid EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        log.info("criar endereço");
        return enderecoService.create(id, endereco);
    }

    @PutMapping("/{idEndereco}")
    public void update(@PathVariable("idEndereco") Integer id,
                       @RequestBody @Valid EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        log.info("atualizar endereço");
        enderecoService.update(id, endereco);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        log.info("deletar endereço");
        enderecoService.delete(id);
    }
}
