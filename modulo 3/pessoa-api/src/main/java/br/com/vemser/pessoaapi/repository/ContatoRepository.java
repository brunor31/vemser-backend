package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.Contato;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
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
    public List<Contato> list(){
        return listaContatos;
    }
    public List<Contato> listById(Integer id){
        return listaContatos.stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .toList();
    }
    public Contato create(Contato contato){
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }
}


