package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.repository.ContatoRepository;

import java.util.List;

public class ContatoService {

    private ContatoRepository contatoRepository;

    public ContatoService(){
        contatoRepository = new ContatoRepository();
    }

    public Contato create(Contato contato){
        PessoaService pessoaService = new PessoaService();
        pessoaService.listar().stream().filter(pessoa -> pessoa.)
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
