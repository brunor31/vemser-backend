package br.com.vemser.pessoaapi.repository;


import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.TipoEndereco;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnderecoRepository {

    private static List<Endereco> listaenderecos = new ArrayList<>();

    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
        listaenderecos.add(new Endereco(COUNTER.incrementAndGet(), 1, TipoEndereco.RESIDENCIAL, "Street 1th", 123
                , "Downtown", "00014-140", "Igrejinha", "RS", "BR"));
        listaenderecos.add(new Endereco(COUNTER.incrementAndGet(), 2, TipoEndereco.COMERCIAL, "Street 2th", 174
                , "Downtown", "00014-152", "Três Coroas", "RS", "BR"));
        listaenderecos.add(new Endereco(COUNTER.incrementAndGet(), 3, TipoEndereco.RESIDENCIAL, "Street 3th", 521
                , "Downtown", "00014-789", "Taquara", "RS", "BR"));
        listaenderecos.add(new Endereco(COUNTER.incrementAndGet(), 4, TipoEndereco.COMERCIAL, "Street 4th", 199
                , "Downtown", "00014-741", "Parobé", "RS", "BR"));
        listaenderecos.add(new Endereco(COUNTER.incrementAndGet(), 5, TipoEndereco.RESIDENCIAL, "Street 5th", 200
                , "Downtown", "00014-000", "Gramado", "RS", "BR"));

    }

    public List<Endereco> list() {
        return listaenderecos;
    }

    public Endereco create(Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaenderecos.add(endereco);
        return endereco;
    }
}
