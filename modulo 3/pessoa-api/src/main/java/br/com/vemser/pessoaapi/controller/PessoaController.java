package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.config.PropertieReader;
import br.com.vemser.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")  // localhost:8080/pessoa/hello
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PropertieReader propertieReader;

    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public List<Pessoa> listByName(@RequestParam("nome") String name){
        return pessoaService.listByName(name);
    }

    @GetMapping // localhost:8080/pessoa
    public List<Pessoa> list(){
        return pessoaService.listar();
    }

    @GetMapping("/ambiente")
    public String propertReader(){
        return propertieReader.getAmbiente();
    }

    @PostMapping // localhost:8080/pessoa
    public Pessoa create(@RequestBody Pessoa pessoa) throws Exception {
        return pessoaService.create(pessoa);
    }

    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public void update(@PathVariable("idPessoa") Integer id,
                       @RequestBody Pessoa pessoa) throws Exception {
        pessoaService.update(id, pessoa);
    }

    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}
