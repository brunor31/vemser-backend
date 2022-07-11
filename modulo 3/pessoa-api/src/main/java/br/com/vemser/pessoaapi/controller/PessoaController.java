package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.config.PropertieReader;
import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.PessoaService;
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

    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public List<PessoaDTO> listByName(@RequestParam("nome") String name) {
        log.info("lista pessoa por nome");
        return pessoaService.listByName(name);
    }

    @GetMapping // localhost:8080/pessoa
    public List<PessoaDTO> list() {
        log.info("listar pessoas");
        return pessoaService.listar();
    }

    @PostMapping // localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@RequestBody @Valid PessoaCreateDTO pessoa) {
        log.info("criar pessoa");
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }

    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public void update(@PathVariable("idPessoa") Integer id,
                       @RequestBody PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        log.info("atualizar pessoa");
        pessoaService.update(id, pessoa);
    }

    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        log.info("deletar pessoa");
        pessoaService.delete(id);
    }
}
