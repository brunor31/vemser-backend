package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.repository.PessoaRepository;

import java.util.List;

public class ContatoService {

    private ContatoRepository contatoRepository;
    private PessoaRepository pessoaRepository;

    public ContatoService(){
        contatoRepository = new ContatoRepository();
        pessoaRepository = new PessoaRepository();
    }

    public Contato create(Contato contato, Integer idPessoa) throws Exception {
        boolean pessoaCadastrada = pessoaRepository.list().stream()
                .anyMatch(pessoa -> pessoa.getIdPessoa().equals(idPessoa));
        if (pessoaCadastrada){
            contato.setIdPessoa(idPessoa);
            return contatoRepository.create(contato);
        }else {
            throw new Exception("Pessoa não encontrada");
        }
    }

    public List<Contato> listar(){
        return contatoRepository.list();
    }

    public Contato update(Integer id, Contato contato) throws Exception{
        return contatoRepository.update(id, contato);
    }

    public void delete(Integer id) throws Exception{
        contatoRepository.delete(id);
    }

    public List<Contato> listById(Integer id){
        return contatoRepository.listById(id);
    }
}
