package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.Contato;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ContatoRepository {

    private static List<Contato> listaContatos = new ArrayList<>();

    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, "RESIDENCIAL", "51996031653", "Wpp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 2, "COMERICAL", "5135498100", "Work"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 3, "RESIDENCIAL", "51995429246", "Wpp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 4, "COMERCIAL", "5135452424", "Work"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 5, "RESIDENCIAL", "51982495757", "Wpp"));
    }

    public Contato create(Contato contato){
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list(){
        return listaContatos;
    }

    public Contato update(Integer id,
                          Contato contatoAtualizar) throws Exception{
        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
        contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception{
        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
        listaContatos.remove(contatoRecuperado);
    }

    public List<Contato> listById(Integer id){
        return listaContatos.stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .toList();
    }
}


