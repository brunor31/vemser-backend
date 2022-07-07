package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> list(){
        return enderecoService.listar();
    }

    @GetMapping("/{idEndereco}")
    public Endereco listById(@PathVariable("idEndereco") Integer id){
        return enderecoService.findById(id);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer id) throws Exception {
        return enderecoService.listByIdPessoa(id);
    }

    @PostMapping("/{idPessoa}")
    public Endereco create(@PathVariable("idPessoa") Integer id,
                           @RequestBody Endereco endereco) throws Exception {
        return enderecoService.create(endereco, id);
    }

    @PutMapping("/{idEndereco}")
    public void update(@PathVariable("idEndereco") Integer id,
                           @RequestBody Endereco endereco){
       enderecoService.update(id, endereco);
    }
    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }
}
