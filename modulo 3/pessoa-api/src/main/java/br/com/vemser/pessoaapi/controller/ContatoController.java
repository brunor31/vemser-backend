package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    private ContatoService contatoService;

    public ContatoController(){
        contatoService = new ContatoService();
    }

    @GetMapping
    public List<Contato> list(){
        return contatoService.listar();
    }

    @GetMapping("/{idPessoa}")
    public List<Contato> listById(@PathVariable("idPessoa") Integer id){
        return contatoService.listById(id);
    }

    @PostMapping
    public Contato create(@RequestBody Contato contato) throws Exception {
        return contatoService.create(contato);
    }

    @PutMapping("/{idContato}")
    public void update(@PathVariable("idContato") Integer id,
                       @RequestBody Contato contato) throws Exception {
        contatoService.update(id, contato);
    }

    @DeleteMapping("{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }
}
