package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.vemser.pessoaapi.dto.DadosPessoaisDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dados-pessoais")
@RestController

public class DadosPessoaisController implements DadosPessoaisClient {

    @Autowired
    private DadosPessoaisClient dadosPessoaisClient;

    @Override
    @GetMapping
    public List<DadosPessoaisDTO> getAll() {
        return dadosPessoaisClient.getAll();
    }

    @Override
    @PostMapping
    public DadosPessoaisDTO post(@RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisClient.post(dadosPessoaisDTO);
    }

    @Override
    @PutMapping("/{cpf}")
    public DadosPessoaisDTO put(@PathVariable("cpf") String cpf, @RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisClient.put(cpf, dadosPessoaisDTO);
    }

    @Override
    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf) {
        dadosPessoaisClient.delete(cpf);
    }

    @Override
    @GetMapping("/{cpf}")
    public DadosPessoaisDTO get(@PathVariable("cpf") String cpf) {
        return dadosPessoaisClient.get(cpf);
    }
}
