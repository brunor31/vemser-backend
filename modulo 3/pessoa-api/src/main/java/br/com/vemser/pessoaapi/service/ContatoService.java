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
    private PessoaService pessoaService;


    public List<Contato> listar() {
        return contatoRepository.list();
    }
    public List<Contato> listByIdPessa(Integer id) throws Exception {
        pessoaService.findById(id);
        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .toList();
    }
    public Contato findById(Integer id) throws Exception {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
        return contatoRecuperado;
    }
    public Contato create(Contato contato, Integer idPessoa) throws Exception {
        Contato contatoCriar = findById(idPessoa);
        return  contatoRepository.create(contato);
    }
    public Contato update(Integer id, Contato contatoAtualizar) throws Exception{
        Contato contatoRecuperar = findById(id);
        contatoRecuperar.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperar.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperar.setNumero(contatoAtualizar.getNumero());
        contatoRecuperar.setDescricao(contatoAtualizar.getDescricao());
        return contatoRecuperar;
    }

    public void delete(Integer id) throws Exception{
        Contato contatoDeletar = findById(id);
        contatoRepository.list().remove(contatoDeletar);
    }
}
