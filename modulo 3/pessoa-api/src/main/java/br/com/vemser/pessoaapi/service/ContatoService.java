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
        return contatoRepository.create(contato);
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
