package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
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
                           @RequestBody @Valid Endereco endereco) throws Exception {
        return enderecoService.create(id, endereco);
    }

    @PutMapping("/{idEndereco}")
    public void update(@PathVariable("idEndereco") Integer id,
                           @RequestBody @Valid Endereco endereco) throws Exception {
       enderecoService.update(id, endereco);
    }
    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }
}
