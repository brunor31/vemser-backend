package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.el.ELException;
import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Endereco create(Endereco endereco, Integer idPessoa) {
        Pessoa pessoaId = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new ELException("Pessoa não encontrada"));
        endereco.setIdPessoa(pessoaId.getIdPessoa());
        return enderecoRepository.create(endereco);
    }

    public List<Endereco> listar() {
        return enderecoRepository.list();
    }

    public Endereco update(Integer id, Endereco endereco) {
        return enderecoRepository.update(id, endereco);
    }

    public void delete(Integer id) throws Exception {
        enderecoRepository.delete(id);
    }

    public List<Endereco> listById(Integer id) {
        return enderecoRepository.listById(id);
    }

    public List<Endereco> listByIdPessoa(Integer id){
        Pessoa pessoaId = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new ELException("Pessoa não encontrada"));
        return enderecoRepository.listByIdPessoa(pessoaId.getIdPessoa());
    }
}
