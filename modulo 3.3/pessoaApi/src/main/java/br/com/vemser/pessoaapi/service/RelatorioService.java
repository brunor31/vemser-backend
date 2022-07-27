package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.RelatorioDTO;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RelatorioService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<RelatorioDTO> relatorios(Integer id){
       return pessoaRepository.relatorioPessoa(id);
    }
}
