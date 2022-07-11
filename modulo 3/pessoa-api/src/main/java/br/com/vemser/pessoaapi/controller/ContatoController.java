package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.ContatoService;
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

    @GetMapping
    public List<ContatoDTO> list() {
        log.info("listar contatos");
        return contatoService.listar();
    }

    @GetMapping("/{idPessoa}")
    public List<ContatoDTO> listById(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        log.info("listar contatos por pessoa");
        return contatoService.listByIdPessoa(id);
    }

    @PostMapping("/{idPessoa}")
    public ContatoDTO create(@PathVariable("idPessoa") Integer id,
                          @RequestBody @Valid ContatoCreateDTO contato) throws RegraDeNegocioException {
        log.info("criar contato");
        return contatoService.create(id, contato);
    }

    @PutMapping("/{idContato}")
    public void update(@PathVariable("idContato") Integer id,
                       @RequestBody @Valid ContatoCreateDTO contato) throws RegraDeNegocioException {
        log.info("atualizar contato");
        contatoService.update(id, contato);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        log.info("deletar contato");
        contatoService.delete(id);
    }
}
