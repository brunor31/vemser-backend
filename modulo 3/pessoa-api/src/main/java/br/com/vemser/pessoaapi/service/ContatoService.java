package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;


    public Contato create(Contato contato, Integer idPessoa) throws Exception {
        boolean pessoaCadastrada = pessoaRepository.list().stream()
                .anyMatch(pessoa -> pessoa.getIdPessoa().equals(idPessoa));
        if (pessoaCadastrada) {
            contato.setIdPessoa(idPessoa);
            return contatoRepository.create(contato);
        } else {
            throw new Exception("Pessoa não encontrada");
        }
    }

    public List<Contato> listar() {
        return contatoRepository.list();
    }

    public Contato update(Integer id, Contato contato) throws Exception {
        return contatoRepository.update(id, contato);
    }

    public void delete(Integer id) throws Exception {
        contatoRepository.delete(id);
    }

    public List<Contato> listById(Integer id) {
        return contatoRepository.listById(id);
    }
}
