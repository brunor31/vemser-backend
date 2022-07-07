package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa create(Pessoa pessoa) throws Exception {
        boolean objetoExiste = ObjectUtils.isEmpty(pessoa);
        boolean nomeEmBranco = StringUtils.isAllBlank(pessoa.getNome());
        if (!objetoExiste || !nomeEmBranco)
        return pessoaRepository.create(pessoa);
        else {
            throw new Exception("Objeto vazio ou nome inválido");
        }
    }

    public List<Pessoa> listar(){
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id, Pessoa pessoaAtualizar) throws Exception{
      return pessoaRepository.update(id, pessoaAtualizar);
    }

    public void delete(Integer id) throws Exception{
        pessoaRepository.delete(id);
    }

    public List<Pessoa> listByName(String name){
        return pessoaRepository.listByName(name);
    }
}
